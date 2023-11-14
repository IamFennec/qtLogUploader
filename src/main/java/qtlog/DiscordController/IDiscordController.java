package qtlog.DiscordController;

import qtlog.shared.LogDTO;

public interface IDiscordController {
    public void sendMessage(LogDTO logInfo);
}
