package data.models;

import java.util.Date;

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

    // Constructors
    public Content() {}

    public Content(String id, String title, String description, String channelId, Date uploadDate, Date downloadDate, String videoPath, String thumbnailPath, String subtitlePath, int videoSize, int duration, int imageHeight, int imageWidth) {
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
}
