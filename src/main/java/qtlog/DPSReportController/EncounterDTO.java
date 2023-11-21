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

    public EncounterDTO(String uniqueId, boolean success, float duration, int compDps, int numberOfPlayers,
            int numberOfGroups, int bossId, String boss, boolean isCm, int gw2Build, boolean jsonAvailable) {
        this.uniqueId = uniqueId;
        this.success = success;
        this.duration = duration;
        this.compDps = compDps;
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfGroups = numberOfGroups;
        this.bossId = bossId;
        this.boss = boss;
        this.isCm = isCm;
        this.gw2Build = gw2Build;
        this.jsonAvailable = jsonAvailable;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public boolean isSuccess() {
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

    public boolean isCm() {
        return this.isCm;
    }

    public int getGw2Build() {
        return this.gw2Build;
    }

    public boolean isJsonAvailable() {
        return this.jsonAvailable;
    }
}
