package qtlog.DiscordController;

import qtlog.DPSReportController.DpsReportDTO;

public interface IDiscordController {
    public void sendMessage(DpsReportDTO logInfo);
}
