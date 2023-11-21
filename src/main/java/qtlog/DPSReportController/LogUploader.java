package qtlog.DPSReportController;

import qtlog.DataModel.ILogObserver;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LogUploader implements ILogUploader, ILogObservable {
    private ILogObserver observer;
    private DpsReportDTO latestLog;

    @Override
    public void registerObs(ILogObserver obs) {
        this.observer = obs;
    }

    @Override
    public void notifyObserver() {
        this.observer.updateLogObserver();
    }

    @Override
    public void uploadLog(Path logPath) {
        try {
            String boundary = Long.toHexString(System.currentTimeMillis());
            File logFile = logPath.toFile();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dps.report/uploadContent?json=1&generator=ei"))
                    .timeout(Duration.ofMinutes(15))
                    .setHeader("Content-Type", "multipart/form-data; boundary=" + boundary)
                    .POST(buildMultipartData(logFile, boundary))
                    .build();

            System.out.println("Uploading " + logPath.getFileName() + " to dps.report.");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response: " + response.statusCode());
            updateLatestLog(response.body());

        } catch (IOException | InterruptedException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        this.notifyObserver();
    }

    @Override
    public DpsReportDTO getLatestLogInfo() {
        return latestLog;
    }

    private static HttpRequest.BodyPublisher buildMultipartData(File file, String boundary) throws IOException {
        List<byte[]> payload = new ArrayList<byte[]>();
        payload.add(("--" + boundary + "\r\n" +
                "Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"\r\n" +
                "Content-Type: application/octet-stream\r\n\r\n").getBytes());
        payload.add(Files.readAllBytes(file.toPath()));
        payload.add(("\r\n--" + boundary + "--\r\n").getBytes());
        return HttpRequest.BodyPublishers.ofByteArrays(payload);
    }

    private void updateLatestLog(String responseJson) {
        System.out.println(responseJson);
    }

}
