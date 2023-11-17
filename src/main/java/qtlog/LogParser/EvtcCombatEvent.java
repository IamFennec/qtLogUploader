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

    private long time;
    private long src_agent;
    private long dst_agent;
    private int value;
    private int buff_dmg;
    private int overstack_value;
    private int skillid;
    private int src_instid;
    private int dst_instid;
    private int src_master_instid;
    private int dst_master_instid;
    private byte iff;
    private byte buff;
    private byte result;
    private byte is_activation;
    private byte is_buffremove;
    private byte is_ninety;
    private byte is_fifty;
    private byte is_moving;
    private byte is_statechange;
    private byte is_flanking;
    private byte is_shields;
    private byte is_offcycle;
    private byte pad61;
    private byte pad62;
    private byte pad63;
    private byte pad64;
}
