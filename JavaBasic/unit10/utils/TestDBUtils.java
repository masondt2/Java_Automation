package unit10.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBUtils {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBUtils.getInstance().getConnection();

        System.out.println(connection);
    }
}
