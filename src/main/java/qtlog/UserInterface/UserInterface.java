package qtlog.UserInterface;

import qtlog.DPSReportController.DpsReportDTO;

public class UserInterface implements IUserInterface {

    @Override
    public void updateUI(DpsReportDTO logInfo) {
        System.out.println("UserInterface updated!\nBoss: " + logInfo.getBossName());
    }
}
