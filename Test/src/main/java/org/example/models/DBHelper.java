package org.example.models;

import java.sql.*;


public class DBHelper {

    private Connection connection;
    static final String url = "jdbc:sqlite:userdb.db";

    public DBHelper() {

         // Specify your database URL

        try {

            connection = DriverManager.getConnection(url);

            System.out.println("Connection Successful");

        } catch (SQLException e) {

            System.out.println("Error Connecting to Database");

            e.printStackTrace();

        }

    }


    public static void createTable() {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " username TEXT UNIQUE, " +
                    " password TEXT)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean registerUser(String username, String password) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO users(username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false; // likely user already exists
        }
    }

    public static boolean loginUser(String username, String password) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public DBHelper(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {

        return connection;

    }


    public void closeConnection() {

        try {

            if (connection != null) {

                System.out.println("Connection Closed");

                connection.close();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}