package qtlog.shared;

import java.util.HashSet;
import java.util.Set;

public class RawLogDTO {
    private long logTime;
    private Set<String> accountNames = new HashSet<>();
    public Set<String> getAccountNames() {
        return accountNames;
    }
    public void setAccountNames(Set<String> accountNames) {
        this.accountNames = accountNames;
    }
    public long getLogTime() {
        return logTime;
    }
    public void setLogTime(long logTime) {
        this.logTime = logTime;
    }

}
