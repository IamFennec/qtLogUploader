package qtlog.LogParser;

import qtlog.shared.FileDTO;
import qtlog.shared.RawLogDTO;

public interface ILogParser {
    public RawLogDTO giveLogToParse(FileDTO fileInfo);
}
