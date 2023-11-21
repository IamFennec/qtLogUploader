package qtlog.shared;

public class LogDTO {
    private String logLink;
    private int uploadTime;
    private boolean success;
    private int duration;
    private String bossName;
    private boolean isCm;

    public LogDTO(String logLink, int uploadTime, boolean success, int duration, String bossName, boolean isCm) {
        this.logLink = logLink;
        this.uploadTime = uploadTime;
        this.success = success;
        this.duration = duration;
        this.bossName = bossName;
        this.isCm = isCm;
    }

    public String getLogLink() {
        return this.logLink;
    }

    public void setLogLink(String logLink) {
        this.logLink = logLink;
    }

    public int getUploadTime() {
        return this.uploadTime;
    }

    public void setUploadTime(int uploadTime) {
        this.uploadTime = uploadTime;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getBossName() {
        return this.bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public boolean isIsCm() {
        return this.isCm;
    }

    public boolean getIsCm() {
        return this.isCm;
    }

    public void setIsCm(boolean isCm) {
        this.isCm = isCm;
    }
}
