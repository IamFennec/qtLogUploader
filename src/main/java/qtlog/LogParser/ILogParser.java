package qtlog.LogParser;

import qtlog.shared.RawLogDTO;

import java.nio.file.Path;

public interface ILogParser {
    public RawLogDTO readLog(Path filePath);
}
