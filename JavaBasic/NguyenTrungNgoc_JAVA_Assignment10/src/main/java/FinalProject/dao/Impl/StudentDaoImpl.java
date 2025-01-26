package FinalProject.dao.Impl;

import FinalProject.dao.StudentDao;
import FinalProject.entity.Student;
import FinalProject.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {
    @Override
    public boolean addStudent(Student student) {
        int result = 0;
        try(Connection connection = DBUtils.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.Student VALUES (?,?,?,?)")) {
            preparedStatement.setString(1,student.getId());
            preparedStatement.setString(2,student.getLastName());
            preparedStatement.setString(3,student.getFirstName());
            preparedStatement.setDate(4,student.getEnrollmentDate());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return result >0;
    }

    @Override
    public boolean updateStudentByFirstName(Student student) {
        int result = 0;
        try(Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE dbo.Student SET EnrollmentDate=? WHERE FirstName = ?")) {
            preparedStatement.setDate(1,student.getEnrollmentDate());
            preparedStatement.setString(2,student.getFirstName());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result >0;
    }
}
