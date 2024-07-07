package data.models;

import java.util.Date;

public class Channel {
    private String id;
    private String title;
    private int pullingIncrement;
    private Date createdAt;

    // Constructors
    public Channel() {}

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

    public int getPullingIncrement() {
        return pullingIncrement;
    }

    public void setPullingIncrement(int pullingIncrement) {
        this.pullingIncrement = pullingIncrement;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
