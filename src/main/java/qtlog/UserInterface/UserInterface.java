package qtlog.UserInterface;

import qtlog.shared.LogDTO;

public class UserInterface implements IUserInterface {

    @Override
    public void updateUI(LogDTO logInfo) {
        System.out.println("UserInterface updated!\nBoss: " + logInfo.getBossName());
    }
}
