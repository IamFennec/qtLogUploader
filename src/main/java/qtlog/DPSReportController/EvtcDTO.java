package qtlog.DPSReportController;

public class EvtcDTO {
    private String type;
    private String version;
    private int bossId;

    public EvtcDTO(String type, String version, int bossId) {
        this.type = type;
        this.version = version;
        this.bossId = bossId;
    }

    public String getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public int getBossId() {
        return this.bossId;
    }

}
