package unit10.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static DBUtils instance;
    private Connection connection;

    private DBUtils() {
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Fsoft_Training;encrypt=true;trustServerCertificate=true;";
            String userName = "sa";
            String password = "abc@123A";

            // 1. Register driver
            Class.forName(driver);

            // 2. Create connection
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBUtils getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DBUtils();
        }

        return instance;
    }
}
