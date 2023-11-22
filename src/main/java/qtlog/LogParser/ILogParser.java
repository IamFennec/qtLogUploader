package qtlog.LogParser;

import java.nio.file.Path;

public interface ILogParser {
    public RawLogDTO readLog(Path filePath);
}
