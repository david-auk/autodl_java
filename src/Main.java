import data.Database;
import data.dao.ChannelDAO;
import data.dao.ContentDAO;
import data.models.Channel;
import data.models.Content;
import utils.Config;
import utils.LocalVid;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Config config = new Config("config.properties");

        for (Channel channel : ChannelDAO.getAll()) { // : ChannelDAO.getRelevant(new Date()) {
            for (Content content : channel.getLatestVideos()){
                System.out.println(content.getTitle());
                if (ContentDAO.get(content.getId()) == null){ // Not found in DB

                    // Download
                    content.downloadVideo(config.get("video_download_dir"));
                    content.downloadThumbnail(config.get("thumbnail_download_dir"));
                    content.downloadSubtitles(config.get("subtitles_download_dir"));


                    //content.setDownloadDate(new Date());
//
//                    System.out.println(content.getThumbnailPath());
//                    if (true) break;
//
//                    // Get and update file attributes
//                    LocalVid localVid = new LocalVid(content.getVideoPath());
//                    content.setVideoSize(localVid.getVideoSize());
//                    content.setDuration(localVid.getVideoDuration());
//                    content.setImageHeight(localVid.getImageHeigth());
//                    content.setImageWidth(localVid.getImageWidth());

                    // Update database
                    //ContentDAO.add(content);
                }else {
                    System.out.println("Found");
                }
            }
            break;
        }
    }
}