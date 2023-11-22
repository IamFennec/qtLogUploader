package qtlog.DiscordController;

import java.io.IOException;

import qtlog.shared.LogDTO;
import qtlog.util.ConfigManager;

public class DiscordController implements IDiscordController{
    private DiscordWebhook webhook;

    public DiscordController(){
        this.webhook = new DiscordWebhook(ConfigManager.readWebhook());
    }

    @Override
    public void sendMessage(LogDTO logInfo) {
        webhook.setContent("Kenzo and David marriage announcement, all welcome");
        webhook.setAvatarUrl("https://en.wikipedia.org/wiki/Same-sex_marriage#/media/File:Wedding_in_New_Orleans,_November_11,_2017.jpg");
        webhook.setUsername("From Kenzo with Love");
        webhook.setTts(true);
        try {
            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
