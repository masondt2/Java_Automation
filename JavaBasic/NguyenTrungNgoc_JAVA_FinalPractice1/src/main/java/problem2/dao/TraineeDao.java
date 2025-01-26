package problem2.dao;

import problem2.entities.Trainee;
import problem2.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TraineeDao {
    public boolean save(Trainee trainee) {
        int result = 0;
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.Trainee VALUES (?,?,?,?,?,?,?)")) {
            preparedStatement.setString(1, trainee.getAccount());
            preparedStatement.setString(2, trainee.getFull_name());
            preparedStatement.setBoolean(3, trainee.isGender());
            preparedStatement.setDate(4, trainee.getBirth_date());
            preparedStatement.setString(5, trainee.getPhone_number());
            preparedStatement.setString(6, trainee.getGpa());
            preparedStatement.setString(7, trainee.getStatus());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    public boolean update(Trainee trainee) {
        int result = 0;
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE dbo.Trainee SET full_name=?, gender=?, birth_date=?,phone_number=?,gpa=?,status=? WHERE account=?")) {
            preparedStatement.setString(1, trainee.getFull_name());
            preparedStatement.setBoolean(2, trainee.isGender());
            preparedStatement.setDate(3, trainee.getBirth_date());
            preparedStatement.setString(4, trainee.getPhone_number());
            preparedStatement.setString(5, trainee.getGpa());
            preparedStatement.setString(6, trainee.getStatus());
            preparedStatement.setString(7, trainee.getAccount());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    public boolean remove() {
        int result = 0;
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM dbo.Trainee WHERE status =?")) {
            preparedStatement.setString(1, "in-active");
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    public List<Trainee> findIncompletedTrainee() {
        List<Trainee> trainees = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery("SELECT * FROM dbo.Trainee WHERE gpa < '6'");
            while (resultSet.next()) {
                Trainee trainee = new Trainee(resultSet.getString(2), resultSet.getString(3), resultSet.getBoolean(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8));
                trainees.add(trainee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainees;
    }

    public List<Trainee> findExcellentTrainee() {
        List<Trainee> trainees = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery("SELECT * FROM dbo.Trainee WHERE gpa <= '100' and gpa>='90'");
            while (resultSet.next()) {
                Trainee trainee = new Trainee(resultSet.getString(2), resultSet.getString(3), resultSet.getBoolean(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8));
                trainees.add(trainee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainees;
    }
}
