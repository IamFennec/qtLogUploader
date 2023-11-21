package qtlog.DPSReportController;

import qtlog.DPSReportController.EvtcDTO;
import qtlog.DPSReportController.PlayersDTO;
import qtlog.DPSReportController.EncounterDTO;
import qtlog.DPSReportController.ReportDTO;

public class DpsReportDTO {
    private String id;
    private String permalink;
    private int uploadTime;
    private int encounterTime;
    private String generator;
    private int generatorId;
    private int generatorVersion;
    private String language;
    private int languageId;
    private EvtcDTO evtc;
    private PlayersDTO players;
    private EncounterDTO encounter;
    private ReportDTO report;
    private String error;
    private String userToken;

    public DpsReportDTO(String id, String permalink, int uploadTime, int encounterTime, String generator,
            int generatorId, int generatorVersion, String language, int languageId, EvtcDTO evtc, PlayersDTO players,
            EncounterDTO encounter, ReportDTO report, String error, String userToken) {
        this.id = id;
        this.permalink = permalink;
        this.uploadTime = uploadTime;
        this.encounterTime = encounterTime;
        this.generator = generator;
        this.generatorId = generatorId;
        this.generatorVersion = generatorVersion;
        this.language = language;
        this.languageId = languageId;
        this.evtc = evtc;
        this.players = players;
        this.encounter = encounter;
        this.report = report;
        this.error = error;
        this.userToken = userToken;
    }

    public String getId() {
        return this.id;
    }

    public String getPermalink() {
        return this.permalink;
    }

    public int getUploadTime() {
        return this.uploadTime;
    }

    public int getEncounterTime() {
        return this.encounterTime;
    }

    public String getGenerator() {
        return this.generator;
    }

    public int getGeneratorId() {
        return this.generatorId;
    }

    public int getGeneratorVersion() {
        return this.generatorVersion;
    }

    public String getLanguage() {
        return this.language;
    }

    public int getLanguageId() {
        return this.languageId;
    }

    public EvtcDTO getEvtc() {
        return this.evtc;
    }

    public PlayersDTO getPlayers() {
        return this.players;
    }

    public EncounterDTO getEncounter() {
        return this.encounter;
    }

    public ReportDTO getReport() {
        return this.report;
    }

    public String getError() {
        return this.error;
    }

    public String getUserToken() {
        return this.userToken;
    }
}
