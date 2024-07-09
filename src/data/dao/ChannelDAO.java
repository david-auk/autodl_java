package data.dao;

import data.Database;
import data.models.Channel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChannelDAO {
    public static void add(Channel channel) {
        String query = "INSERT INTO channel (id, title, pulling_increment, created_at) VALUES (?, ?, ?, ?)";

        try (Connection connection = Database.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, channel.getId());
            preparedStatement.setString(2, channel.getTitle());
            preparedStatement.setInt(3, channel.getPullingIncrement());
            preparedStatement.setDate(4, new Date(channel.getCreatedAt().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Channel get(String id) {
        String query = "SELECT * FROM channel WHERE id = ?";
        Channel channel = null;

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                channel = new Channel();
                channel.setId(resultSet.getString("id"));
                channel.setTitle(resultSet.getString("title"));
                channel.setPullingIncrement(resultSet.getInt("pulling_increment"));
                channel.setCreatedAt(resultSet.getDate("created_at"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return channel;
    }

    public static List<Channel> getAll() {
        String query = "SELECT * FROM channel";
        List<Channel> users = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Channel channel = new Channel();
                channel.setId(resultSet.getString("id"));
                channel.setTitle(resultSet.getString("title"));
                channel.setPullingIncrement(resultSet.getInt("pulling_increment"));
                channel.setCreatedAt(resultSet.getDate("created_at"));
                users.add(channel);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return users;
    }

    public static void update(Channel channel) {
        String query = "UPDATE channel SET title = ?, pulling_increment = ?, created_at = ? WHERE id = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, channel.getTitle());
            preparedStatement.setInt(2, channel.getPullingIncrement());
            preparedStatement.setDate(3, new Date(channel.getCreatedAt().getTime()));
            preparedStatement.setString(4, channel.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        String query = "DELETE FROM channel WHERE id = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}