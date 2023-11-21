package qtlog.LogParser;

import qtlog.shared.RawLogDTO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class LogParser implements ILogParser {
    private int agentCount;
    private int skillCount;

    @Override
    public RawLogDTO readLog(Path filePath) {
        ByteArrayInputStream byteArrayStream;

        try {
            if (logIsZipped(filePath.toString())) {
                byte[] unzippedLog = unzipLog(filePath.toString());
                byteArrayStream = new ByteArrayInputStream(unzippedLog);
                return parseLog(byteArrayStream);
            } else {
                byte[] fileContent;
                fileContent = Files.readAllBytes(filePath);
                byteArrayStream = new ByteArrayInputStream(fileContent);
                return parseLog(byteArrayStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RawLogDTO();
    }

    private boolean logIsZipped(String filename) {
        return filename.charAt(filename.length() - 5) == 'z';
    }

    private byte[] unzipLog(String filepath) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(filepath))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                int len;
                while ((len = zipInputStream.read(buffer)) > 0) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }

                zipEntry = zipInputStream.getNextEntry();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private RawLogDTO parseLog(ByteArrayInputStream byteStream) {
        RawLogDTO tempLogDTO = new RawLogDTO();

        try {
            // parse log
            EvtcHeader header = getHeader(byteStream);
            agentCount = this.getInt(byteStream);
            ArrayList<EvtcAgent> agents = getAgentInfo(byteStream);
            skillCount = this.getInt(byteStream);
            ArrayList<EvtcSkill> skills = getSkillInfo(byteStream);
            ArrayList<EvtcCombatEvent> cbtevts = getCombatEventsInfo(byteStream);

            // fill relevant data for further processing
            // get time passed
            long timePassed = cbtevts.get(cbtevts.size() - 1).getTime() - cbtevts.get(0).getTime();

            // get account names from log
            Set<String> accNames = new HashSet<>();
            for (EvtcAgent agent : agents) {
                if (agent.getName().contains(".")) {
                    int accNameIndex = agent.getName().indexOf(":") + 1;
                    int end = agent.getName().indexOf("\u0000", accNameIndex);
                    String accountName = agent.getName().substring(accNameIndex, end);
                    accNames.add(accountName);
                    // System.out.println(accountName);
                }
            }

            System.out.println(timePassed);
            // set fields
            tempLogDTO.setAccountNames(accNames);
            tempLogDTO.setLogTime(timePassed);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tempLogDTO;
    }

    private int getShort(ByteArrayInputStream byteStream) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
        byteStream.read(buffer.array());
        return buffer.getShort() & 0xFFFF;
    }

    private int getInt(ByteArrayInputStream byteStream) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        byteStream.read(buffer.array());
        return buffer.getInt();
    }

    private long getLong(ByteArrayInputStream byteStream) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
        byteStream.read(buffer.array());
        return buffer.getLong();
    }

    private EvtcHeader getHeader(ByteArrayInputStream byteStream) {
        EvtcHeader header;
        try {
            // read Version/Date
            byte[] date = new byte[12];
            byteStream.read(date);
            String dateString = new String(date, StandardCharsets.UTF_8);

            // read revision byte
            byte revision = (byte) byteStream.read();

            // read bossID
            int bossID = getShort(byteStream);

            // read speciesID (unused)
            byte speciesID = (byte) byteStream.read();

            header = new EvtcHeader(dateString, revision, bossID, speciesID);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return header;
    }

    private EvtcAgent readAgent(ByteArrayInputStream byteStream) {
        EvtcAgent agent;

        // read agent
        try {
            long addr = getLong(byteStream);
            int prof = getInt(byteStream);
            int is_Elite = getInt(byteStream);
            int toughness = getShort(byteStream);
            int concentration = getShort(byteStream);
            int healing = getShort(byteStream);
            int hitbox_width = getShort(byteStream);
            int condition = getShort(byteStream);
            int hitbox_height = getShort(byteStream);
            byte[] name = new byte[68];
            byteStream.read(name);
            String nameString = new String(name, StandardCharsets.UTF_8).trim();

            agent = new EvtcAgent(addr, prof, is_Elite, toughness, concentration, healing, hitbox_width, condition,
                    hitbox_height, nameString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return agent;
    }

    private ArrayList<EvtcAgent> getAgentInfo(ByteArrayInputStream byteStream) {
        ArrayList<EvtcAgent> tempAgents = new ArrayList<>();
        for (int i = 0; i < agentCount; i++) {
            tempAgents.add(readAgent(byteStream));
        }
        return tempAgents;
    }

    private EvtcSkill readSkill(ByteArrayInputStream byteStream) {
        EvtcSkill skill;

        // read skill
        try {
            int id = this.getInt(byteStream);
            byte[] name = new byte[64];
            byteStream.read(name);
            String nameString = new String(name, StandardCharsets.UTF_8);

            skill = new EvtcSkill(id, nameString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return skill;
    }

    private ArrayList<EvtcSkill> getSkillInfo(ByteArrayInputStream byteStream) {
        ArrayList<EvtcSkill> tempSkills = new ArrayList<>();
        for (int i = 0; i < skillCount; i++) {
            tempSkills.add(readSkill(byteStream));
        }
        return tempSkills;
    }

    private EvtcCombatEvent readCombatEvent(ByteArrayInputStream byteStream) {
        EvtcCombatEvent cbtevt;

        // read combat event
        try {
            long time = getLong(byteStream);
            long src_agent = getLong(byteStream);
            long dst_agent = getLong(byteStream);
            int value = getInt(byteStream);
            int buff_dmg = getInt(byteStream);
            int overstack_value = getInt(byteStream);
            int skillid = getInt(byteStream);
            int src_instid = getShort(byteStream);
            int dst_instid = getShort(byteStream);
            int src_master_instid = getShort(byteStream);
            int dst_master_instid = getShort(byteStream);
            byte iff = (byte) byteStream.read();
            byte buff = (byte) byteStream.read();
            byte result = (byte) byteStream.read();
            byte is_activation = (byte) byteStream.read();
            byte is_buffremove = (byte) byteStream.read();
            byte is_ninety = (byte) byteStream.read();
            byte is_fifty = (byte) byteStream.read();
            byte is_moving = (byte) byteStream.read();
            byte is_statechange = (byte) byteStream.read();
            byte is_flanking = (byte) byteStream.read();
            byte is_shields = (byte) byteStream.read();
            byte is_offcycle = (byte) byteStream.read();
            byte pad61 = (byte) byteStream.read();
            byte pad62 = (byte) byteStream.read();
            byte pad63 = (byte) byteStream.read();
            byte pad64 = (byte) byteStream.read();

            cbtevt = new EvtcCombatEvent(time, src_agent, dst_agent, value, buff_dmg, overstack_value, skillid,
                    src_instid,
                    dst_instid, src_master_instid, dst_master_instid, iff, buff, result, is_activation, is_buffremove,
                    is_ninety, is_fifty, is_moving, is_statechange, is_flanking, is_shields, is_offcycle, pad61, pad62,
                    pad63, pad64);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cbtevt;
    }

    private ArrayList<EvtcCombatEvent> getCombatEventsInfo(ByteArrayInputStream byteStream) {
        ArrayList<EvtcCombatEvent> cbtevts = new ArrayList<>();
        while (byteStream.available() > 0) {
            cbtevts.add(readCombatEvent(byteStream));
        }
        return cbtevts;
    }
}
