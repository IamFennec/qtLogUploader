package qtlog.DPSReportController;

public class PlayerDTO {
    private String displayName;
    private String characterName;
    private int profession;
    private int elite_spec;

    public PlayerDTO(String displayName, String characterName, int profession, int elite_spec) {
        this.displayName = displayName;
        this.characterName = characterName;
        this.profession = profession;
        this.elite_spec = elite_spec;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getCharacterName() {
        return this.characterName;
    }

    public int getProfession() {
        return this.profession;
    }

    public int getEliteSpec() {
        return this.elite_spec;
    }
}
