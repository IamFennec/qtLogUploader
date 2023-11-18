package qtlog.LogParser;

public class EvtcHeader {
    private String date;
    private byte revision;
    private int bossID;
    private byte speciesId;

    public EvtcHeader(String date, byte revision, int bossID, byte speciesId) {
        this.date = date;
        this.revision = revision;
        this.bossID = bossID;
        this.speciesId = speciesId;
    }
}
