import data.dao.ChannelDAO;
import data.dao.ContentDAO;
import data.models.Channel;
import data.models.Content;
import utils.Youtube;

public class Main {
    public static void main(String[] args) {

        for (Channel channel : ChannelDAO.getAll()) { // : ChannelDAO.getRelevant(new Date()) {
            for (Content content : Youtube.getLatestVideos(channel.getId())){
                System.out.println(content.getTitle());
                if (ContentDAO.get(content.getId()) == null){
                    System.out.println("Not found");
                }else {
                    System.out.println("Found");
                }
            }
        }
    }
}