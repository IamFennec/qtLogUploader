package qtlog.DPSReportController;

import qtlog.DPSReportController.PlayerDTO;

public class PlayersDTO {
    private PlayerDTO[] players;

    public PlayersDTO(PlayerDTO[] players) {
        this.players = players;
    }

    public PlayerDTO[] getPlayers() {
        return players;
    }
}
