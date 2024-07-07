package data.models;
import java.time.LocalDateTime;

public class Content {
    private String id;
    private String title;
    private String description;
    private String channelId;
    private LocalDateTime uploadDate;
    private LocalDateTime downloadDate;
    private String videoPath;
    private String thumbnailPath;
    private String subtitlePath;
    private long videoSize;
    private int duration;
    private int imageHeight;
    private int imageWidth;

    // Constructors
    public Content() {}

    public Content(String id, String title, String description, String channelId, LocalDateTime uploadDate, LocalDateTime downloadDate, String videoPath, String thumbnailPath, String subtitlePath, long videoSize, int duration, int imageHeight, int imageWidth) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.channelId = channelId;
        this.uploadDate = uploadDate;
        this.downloadDate = downloadDate;
        this.videoPath = videoPath;
        this.thumbnailPath = thumbnailPath;
        this.subtitlePath = subtitlePath;
        this.videoSize = videoSize;
        this.duration = duration;
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
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

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public LocalDateTime getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(LocalDateTime downloadDate) {
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

    public long getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(long videoSize) {
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
}
