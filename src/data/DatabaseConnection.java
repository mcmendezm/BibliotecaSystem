package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/biblioteca";
    private String username = "root";
    private String password = "nodo";

    public DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión establecida.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
