package qtlog.LogParser;

public class EvtcCombatEvent {
    public EvtcCombatEvent(long time, long src_agent, long dst_agent, int value, int buff_dmg, int overstack_value,
                           int skillid, int src_instid, int dst_instid, int src_master_instid, int dst_master_instid,
                           byte iff, byte buff, byte result, byte is_activation, byte is_buffremove, byte is_ninety,
                           byte is_fifty, byte is_moving, byte is_statechange, byte is_flanking, byte is_shields,
                           byte is_offcycle, byte pad61, byte pad62, byte pad63, byte pad64) {
        this.time = time;
        this.src_agent = src_agent;
        this.dst_agent = dst_agent;
        this.value = value;
        this.buff_dmg = buff_dmg;
        this.overstack_value = overstack_value;
        this.skillid = skillid;
        this.src_instid = src_instid;
        this.dst_instid = dst_instid;
        this.src_master_instid = src_master_instid;
        this.dst_master_instid = dst_master_instid;
        this.iff = iff;
        this.buff = buff;
        this.result = result;
        this.is_activation = is_activation;
        this.is_buffremove = is_buffremove;
        this.is_ninety = is_ninety;
        this.is_fifty = is_fifty;
        this.is_moving = is_moving;
        this.is_statechange = is_statechange;
        this.is_flanking = is_flanking;
        this.is_shields = is_shields;
        this.is_offcycle = is_offcycle;
        this.pad61 = pad61;
        this.pad62 = pad62;
        this.pad63 = pad63;
        this.pad64 = pad64;
    }

    private final long time;
    private final long src_agent;
    private final long dst_agent;
    private final int value;
    private final int buff_dmg;
    private final int overstack_value;
    private final int skillid;
    private final int src_instid;
    private final int dst_instid;
    private final int src_master_instid;
    private final int dst_master_instid;
    private final byte iff;
    private final byte buff;
    private final byte result;
    private final byte is_activation;
    private final byte is_buffremove;
    private final byte is_ninety;
    private final byte is_fifty;
    private final byte is_moving;
    private final byte is_statechange;
    private final byte is_flanking;
    private final byte is_shields;
    private final byte is_offcycle;
    private final byte pad61;
    private final byte pad62;
    private final byte pad63;
    private final byte pad64;

    public long getTime() {
        return time;
    }

    public long getSrc_agent() {
        return src_agent;
    }

    public long getDst_agent() {
        return dst_agent;
    }

    public int getValue() {
        return value;
    }

    public int getBuff_dmg() {
        return buff_dmg;
    }

    public int getOverstack_value() {
        return overstack_value;
    }

    public int getSkillid() {
        return skillid;
    }

    public int getSrc_instid() {
        return src_instid;
    }

    public int getDst_instid() {
        return dst_instid;
    }

    public int getSrc_master_instid() {
        return src_master_instid;
    }

    public int getDst_master_instid() {
        return dst_master_instid;
    }

    public byte getIff() {
        return iff;
    }

    public byte getBuff() {
        return buff;
    }

    public byte getResult() {
        return result;
    }

    public byte getIs_activation() {
        return is_activation;
    }

    public byte getIs_buffremove() {
        return is_buffremove;
    }

    public byte getIs_ninety() {
        return is_ninety;
    }

    public byte getIs_fifty() {
        return is_fifty;
    }

    public byte getIs_moving() {
        return is_moving;
    }

    public byte getIs_statechange() {
        return is_statechange;
    }

    public byte getIs_flanking() {
        return is_flanking;
    }

    public byte getIs_shields() {
        return is_shields;
    }

    public byte getIs_offcycle() {
        return is_offcycle;
    }

    public byte getPad61() {
        return pad61;
    }

    public byte getPad62() {
        return pad62;
    }

    public byte getPad63() {
        return pad63;
    }

    public byte getPad64() {
        return pad64;
    }
}
