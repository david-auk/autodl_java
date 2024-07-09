package data.models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Channel {
    private String id;
    private String title;
    private int pullingIncrement;
    private Date createdAt;

    // Constructors
    public Channel() {}

    // Functional methods
    public List<Content> getLatestVideos() {
        // Replace this with the RSS feed URL of the YouTube channel you want to scrape
        String rssUrl = String.format("https://www.youtube.com/feeds/videos.xml?channel_id=%s", id);

        List<Content> contents = new ArrayList<>();

        try {
            // Connect to the RSS feed and parse the XML
            Document doc = Jsoup.connect(rssUrl).get();

            // Select the entry elements (each entry represents a video)
            Elements entryElements = doc.select("entry");

            // Loop through the entry elements and extract information
            for (Element entryElement : entryElements) {
                Content content = new Content();

                content.setId(entryElement.select("yt|videoId").text());
                content.setTitle(entryElement.select("title").text());
                content.setDescription(entryElement.select("media|description").first().html());
                content.setChannelId(id);
                content.setUploadDate(getDateFromString(entryElement.select("published").text()));

                content.setAlternativeThumbnailDownloadUrl(entryElement.select("media|thumbnail").first().attr("url"));

                contents.add(content);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
    }
    private static Date getDateFromString(String string){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

        // Set the time zone to UTC to match the +00:00 offset
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = null;

        try {
            // Parse the string into a Date object
            date = dateFormat.parse(string);
        }
        catch (ParseException e){}
        return date;
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
