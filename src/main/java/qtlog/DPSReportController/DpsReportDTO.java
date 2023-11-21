package qtlog.DPSReportController;

import qtlog.DPSReportController.EvtcDTO;
import qtlog.DPSReportController.PlayerDTO;
import qtlog.DPSReportController.EncounterDTO;
import qtlog.DPSReportController.ReportDTO;

import java.util.Map;

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
    private Map<String, PlayerDTO> players;
    private EncounterDTO encounter;
    private ReportDTO report;
    private String error;
    private String userToken;

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

    public Map<String, PlayerDTO> getPlayers() {
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
