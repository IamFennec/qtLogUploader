package qtlog.DPSReportController;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDTO {
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("character_name")
    private String characterName;
    private int profession;
    @JsonProperty("elite_spec")
    private int eliteSpec;

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
        return this.eliteSpec;
    }
}
