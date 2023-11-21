package qtlog.LogParser;

public class EvtcHeader {
    private final String date;
    private final byte revision;
    private final int bossID;
    private final byte speciesId;

    public EvtcHeader(String date, byte revision, int bossID, byte speciesId) {
        this.date = date;
        this.revision = revision;
        this.bossID = bossID;
        this.speciesId = speciesId;
    }

    public String getDate() {
        return date;
    }

    public byte getRevision() {
        return revision;
    }

    public int getBossID() {
        return bossID;
    }

    public byte getSpeciesId() {
        return speciesId;
    }

}
