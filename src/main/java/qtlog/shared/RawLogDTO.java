package qtlog.shared;

import java.util.HashSet;
import java.util.Set;

public class RawLogDTO {
    private int logTime;
    private Set<String> accountNames = new HashSet<>();
    public int getLogTime() {
        return logTime;
    }
    public void setLogTime(int logTime) {
        this.logTime = logTime;
    }
}
