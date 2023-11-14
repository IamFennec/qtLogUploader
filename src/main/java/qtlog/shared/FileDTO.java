package qtlog.shared;

public class FileDTO {
    private String filename;
    private String filepath;

    public FileDTO(String filename, String filepath){
        this.filename = filename;
        this.filepath = filepath;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return this.filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
