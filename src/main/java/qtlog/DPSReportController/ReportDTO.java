package qtlog.DPSReportController;

public class ReportDTO {
    private boolean anonymous;
    private boolean detailed;

    public ReportDTO(boolean anonymous, boolean detailed) {
        this.anonymous = anonymous;
        this.detailed = detailed;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public boolean isDetailed() {
        return detailed;
    }
}
