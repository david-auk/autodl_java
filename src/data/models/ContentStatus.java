package data.models;
import java.time.LocalDateTime;

public class ContentStatus {
    private int id;
    private String contentId;
    private short isAvailable;
    private String status;
    private LocalDateTime date;

    // Constructors
    public ContentStatus() {}

    public ContentStatus(int id, String contentId, short isAvailable, String status, LocalDateTime date) {
        this.id = id;
        this.contentId = contentId;
        this.isAvailable = isAvailable;
        this.status = status;
        this.date = date;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public short getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(short isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
