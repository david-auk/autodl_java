package data.dao;

import data.Database;
import data.models.Channel;
import data.models.Content;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContentDAO {
    public static void add(Content content) {
        String query = "INSERT INTO content (id, title, description, channel_id, upload_date, download_date, video_path, thumbnail_path, subtitle_path, video_size, duration, image_height, image_width) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = Database.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, content.getId());
            preparedStatement.setString(2, content.getTitle());
            preparedStatement.setString(3, content.getDescription());
            preparedStatement.setString(4, content.getChannelId());
            preparedStatement.setDate(5, new Date(content.getUploadDate().getTime()));
            preparedStatement.setDate(6, new Date(content.getDownloadDate().getTime()));
            preparedStatement.setString(7, content.getVideoPath());
            preparedStatement.setString(8, content.getThumbnailPath());
            preparedStatement.setString(9, content.getSubtitlePath());
            preparedStatement.setInt(10, content.getVideoSize());
            preparedStatement.setInt(11, content.getDuration());
            preparedStatement.setInt(11, content.getImageHeight());
            preparedStatement.setInt(12, content.getImageWidth());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Content get(String id) {
        String query = "SELECT * FROM channel WHERE id = ?";
        Content content = null;

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                content = new Content();
                content.setId(resultSet.getString("id"));
                content.setTitle(resultSet.getString("title"));
                content.setDescription(resultSet.getString("description"));
                content.setChannelId(resultSet.getString("channel_id"));
                content.setUploadDate(resultSet.getDate("upload_date"));
                content.setDownloadDate(resultSet.getDate("download_date"));
                content.setVideoPath(resultSet.getString("video_path"));
                content.setThumbnailPath(resultSet.getString("thumbnail_path"));
                content.setSubtitlePath(resultSet.getString("subtitle_path"));
                content.setVideoSize(resultSet.getInt("video_size"));
                content.setDuration(resultSet.getInt("duration"));
                content.setImageHeight(resultSet.getInt("image_height"));
                content.setImageWidth(resultSet.getInt("image_width"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return content;
    }

    public static List<Content> getAll() {
        String query = "SELECT * FROM content";
        List<Content> contents = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Content content = new Content();
                content.setId(resultSet.getString("id"));
                content.setTitle(resultSet.getString("title"));
                content.setDescription(resultSet.getString("description"));
                content.setChannelId(resultSet.getString("channel_id"));
                content.setUploadDate(resultSet.getDate("upload_date"));
                content.setDownloadDate(resultSet.getDate("download_date"));
                content.setVideoPath(resultSet.getString("video_path"));
                content.setThumbnailPath(resultSet.getString("thumbnail_path"));
                content.setSubtitlePath(resultSet.getString("subtitle_path"));
                content.setVideoSize(resultSet.getInt("video_size"));
                content.setDuration(resultSet.getInt("duration"));
                content.setImageHeight(resultSet.getInt("image_height"));
                content.setImageWidth(resultSet.getInt("image_width"));
                contents.add(content);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return contents;
    }

    public static void update(Content content) {
        String query = "UPDATE content SET title = ?, description = ?, channel_id = ?, upload_date = ?, download_date = ?, video_path = ?, thumbnail_path = ?, subtitle_path = ?, video_size = ?, duration = ?, image_height = ?, image_width = ? WHERE id = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, content.getTitle());
            preparedStatement.setString(2, content.getDescription());
            preparedStatement.setString(3, content.getChannelId());
            preparedStatement.setDate(4, new Date(content.getUploadDate().getTime()));
            preparedStatement.setDate(5, new Date(content.getDownloadDate().getTime()));
            preparedStatement.setString(6, content.getVideoPath());
            preparedStatement.setString(7, content.getThumbnailPath());
            preparedStatement.setString(8, content.getSubtitlePath());
            preparedStatement.setInt(9, content.getVideoSize());
            preparedStatement.setInt(10, content.getDuration());
            preparedStatement.setInt(11, content.getImageHeight());
            preparedStatement.setInt(12, content.getImageWidth());
            preparedStatement.setString(13, content.getId());

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

            preparedStatement.setString(0, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}