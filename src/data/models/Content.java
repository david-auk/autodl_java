package data.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Content {
    private String id;
    private String title;
    private String description;
    private String channelId;
    private Date uploadDate;
    private Date downloadDate;
    private String videoPath;
    private String thumbnailPath;
    private String subtitlePath;
    private int videoSize;
    private int duration;
    private int imageHeight;
    private int imageWidth;

    private String alternativeThumbnailDownloadUrl;



    // Constructors
    public Content() {}

    // Functional methods
    public void downloadVideo(String downloadDirectory){
        String command = "yt-dlp " +
                "-f bestvideo+bestaudio " +
                "--merge-output-format mp4 " +
                "-o " + downloadDirectory.replaceAll("/$", "") + "/" + id + ".%(ext)s " +
                " https://www.youtube.com/watch?v=" + id;

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                String pattern = "^\\[Merger] Merging formats into \"(.*\\.mp4)\"|^\\[download] (.*\\.mp4) has already been downloaded$";
                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(line);
                if (m.find()) {
                    if (m.group(1) != null) {
                        videoPath = m.group(1);
                    } else if (m.group(2) != null) {
                        videoPath = m.group(2);
                    }
                    break;
                }
            }

            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Download completed successfully.");
            } else {
                System.err.println("Error occurred while downloading video. Exit code: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void downloadThumbnail(String downloadDirectory){
        thumbnailPath = downloadDirectory.replaceAll("/$", "") + "/" + id + ".jpg";

        HttpClient client = HttpClient.newHttpClient();

        try {
            downloadFile(client, "https://img.youtube.com/vi/" + id + "/maxresdefault.jpg", thumbnailPath);
        } catch (Exception e) {
            downloadFile(client, alternativeThumbnailDownloadUrl, thumbnailPath);
        }
    }

    private void downloadFile(HttpClient client, String urlStr, String file) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlStr))
                .build();

        HttpResponse<Path> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofFile(Path.of(file)));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Ensure the response status code is 200 OK
        if (response.statusCode() != 200) {
            try {
                throw new IOException("Failed to download file: " + response.statusCode());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void downloadSubtitles(String downloadDirectory){}

    private boolean subtitlesAvalible(String videoId){
        return false;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getSubtitlePath() {
        return subtitlePath;
    }

    public void setSubtitlePath(String subtitlePath) {
        this.subtitlePath = subtitlePath;
    }

    public int getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(int videoSize) {
        this.videoSize = videoSize;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public void setAlternativeThumbnailDownloadUrl(String alternativeThumbnailDownloadUrl) {
        this.alternativeThumbnailDownloadUrl = alternativeThumbnailDownloadUrl;
    }
}
