package FinalProject.dao.Impl;

import FinalProject.dao.EnrollmentDao;
import FinalProject.entity.Enrollment;
import FinalProject.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnrollmentDaoImpl implements EnrollmentDao {
    @Override
    public boolean addEnrollment(Enrollment enrollment) {
        int result = 0;
        try(Connection connection = DBUtils.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.Enrollment VALUES (?,?,?,?)")) {
            preparedStatement.setString(1,enrollment.getId());
            preparedStatement.setString(2,enrollment.getCourseId());
            preparedStatement.setString(3,enrollment.getStudentId());
            preparedStatement.setString(4,enrollment.getGrade());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return result > 0;
    }
}
