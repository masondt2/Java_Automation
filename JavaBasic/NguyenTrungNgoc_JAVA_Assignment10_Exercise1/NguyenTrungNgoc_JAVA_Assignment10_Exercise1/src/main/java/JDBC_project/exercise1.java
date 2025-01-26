package JDBC_project;

import JDBC_project.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class exercise1 {
    public static void main(String[] args) {
        try {
            Connection connection = DBUtils.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String tableQuerry = "SELECT name FROM sys.tables";
            ResultSet tableResultSet = statement.executeQuery(tableQuerry);
            while (tableResultSet.next()) {
                String tableName = tableResultSet.getString("name");
                System.out.println("Table Name: " + tableName);
            }
            String columnsQuery = "select cl.name as 'Column Name', tp.name as 'Type'\n" +
                        "from sys.all_columns cl join sys.types tp \n" +
                        "on cl.user_type_id = tp.user_type_id \n" +
                        "where object_id in(\n" +
                        "SELECT object_id from sys.tables)";
            ResultSet columnResultSet = statement.executeQuery(columnsQuery);
            while (columnResultSet.next()) {
                    String columnName = columnResultSet.getString("Column name");
                    String columnType = columnResultSet.getString("Type");
                    System.out.println("Column Name: " + columnName+" | Type: "+ columnType);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
