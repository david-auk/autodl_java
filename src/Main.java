import data.dao.ChannelDAO;
import data.models.Channel;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Channel channel = new Channel();
        channel.setId("UCB0JSO6d5ysH2Mmqz5I9rIw");
        channel.setTitle("AC/DC");
        channel.setPullingIncrement(4);
        channel.setCreatedAt(new Date());

        ChannelDAO.add(channel);

//        for (Channel channel : ChannelDAO.getAll()){
//            System.out.println(channel.getTitle());
//        }
    }
}
