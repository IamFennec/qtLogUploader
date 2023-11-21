package qtlog.DPSReportController;

import qtlog.DPSReportController.EvtcDTO;
import qtlog.DPSReportController.PlayersDTO;

// {
//     "id": "d72e-20231121-194731",
//     "permalink": "https:\/\/dps.report\/d72e-20231121-194731_golem",
//     "uploadTime": 1700592448,
//     "encounterTime": 1700592426,
//     "generator": "Elite Insights",
//     "generatorId": 1,
//     "generatorVersion": 2,
//     "language": "en",
//     "languageId": 0,
//     "evtc": {
//         "type": "EVTC",
//         "version": "20231113",
//         "bossId": 16199
//     },
//     "players": {
//         "Subi Akame": {
//             "display_name": "Subi.8014",
//             "character_name": "Subi Akame",
//             "profession": 2,
//             "elite_spec": 61
//         }
//     },
//     "encounter": {
//         "uniqueId": null,
//         "success": false,
//         "duration": 21.49,
//         "compDps": 10652,
//         "numberOfPlayers": 1,
//         "numberOfGroups": 1,
//         "bossId": 16199,
//         "boss": "Standard Kitty Golem",
//         "isCm": false,
//         "gw2Build": 154410,
//         "jsonAvailable": true
//     },
//     "report": {
//         "anonymous": false,
//         "detailed": false
//     },
//     "error": null,
//     "userToken": "t39n48mmsqjskpbfi2sdmn42qmncfa5s"
// }

public class DpsReportDTO {
    private String id;
    private String permalink;
    private int uploadTime;
    private int encounterTime;
    private String generator;
    private int generatorId;
    private int generatorVersion;
    private String language;
    private int languageId;
    private EvtcDTO evtc;
    private PlayersDTO players;

}
