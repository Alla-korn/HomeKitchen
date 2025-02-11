package com.example.myapplication2.ui;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "11112011";

    private Connection connection;

    public Database() {
        this.connection = connect(); // Инициализация поля класса
    }

    public static Connection connect() {
        Connection conn = null; // Локальная переменная
        try {
            conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.err.println("Connection failed!");
            e.printStackTrace();
        }
        return conn; // Возвращаем локальное соединение
    }

    public boolean isUserExists(String username, String password) {
        boolean exists = false;
        String query = "SELECT COUNT(*) FROM HomeKitchenUsers WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) { // Закрываем ResultSet
                if (resultSet.next()) {
                    exists = resultSet.getInt(1) > 0; // Если COUNT(*) больше 0, значит пользователь существует
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
