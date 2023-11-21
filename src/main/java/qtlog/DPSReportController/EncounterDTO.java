package qtlog.DPSReportController;

public class EncounterDTO {
    private String uniqueId;
    private boolean success;
    private float duration;
    private int compDps;
    private int numberOfPlayers;
    private int numberOfGroups;
    private int bossId;
    private String boss;

    private boolean isCm;
    private int gw2Build;
    private boolean jsonAvailable;

    public String getUniqueId() {
        return this.uniqueId;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public float getDuration() {
        return this.duration;
    }

    public int getCompDps() {
        return this.compDps;
    }

    public int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    public int getNumberOfGroups() {
        return this.numberOfGroups;
    }

    public int getBossId() {
        return this.bossId;
    }

    public String getBoss() {
        return this.boss;
    }

    public boolean getIsCm() {
        return this.isCm;
    }

    public int getGw2Build() {
        return this.gw2Build;
    }

    public boolean getJsonAvailable() {
        return this.jsonAvailable;
    }
}
