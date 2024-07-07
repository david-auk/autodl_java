package data;

import utils.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    static Config secret = new Config("secret.properties");

    private static final String URL = String.format("jdbc:mysql://%s:%s/%s",
            secret.get("db_host"),
            secret.get("db_port"),
            secret.get("db_name")
    );
    private static final String USER = secret.get("db_username");
    private static final String PASSWORD = secret.get("db_password");

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}