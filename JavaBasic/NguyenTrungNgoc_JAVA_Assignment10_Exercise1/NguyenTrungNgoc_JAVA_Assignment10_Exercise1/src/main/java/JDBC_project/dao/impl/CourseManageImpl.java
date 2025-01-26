package JDBC_project.dao.impl;

import JDBC_project.dao.CourseManagenmentDao;
import JDBC_project.entity.Course;
import JDBC_project.entity.Enrollment;
import JDBC_project.entity.Student;
import JDBC_project.utils.DBUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CourseManageImpl implements CourseManagenmentDao {

    @Override
    public boolean saveCourse(Course course) {
            int result = 0;
            try (Connection connection = DBUtils.getInstance().getConnection();
                 // Create statement
                 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.Course VALUES (?,?,?)")) {
                preparedStatement.setString(1, course.getCourseId());
                preparedStatement.setString(2, course.getCourseTitle());
                preparedStatement.setInt(3, course.getCredit());
                // 4. Execute statement
                result = preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return (result > 0);
    }

    @Override
    public boolean saveStudent(Student student) {
        int result = 0;
        try(Connection connection = DBUtils.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.Student VALUES (?,?,?,?)")){
                preparedStatement.setString(1, student.getStudentId());
                preparedStatement.setString(2, student.getFirstName());
                preparedStatement.setString(3, student.getLastName());
                preparedStatement.setDate(4, (Date) student.getEnrollmentDate());
                result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return (result > 0);
    }

    @Override
    public boolean saveEnrollment(Enrollment enrollment) {
        int result = 0;
        try(Connection connection = DBUtils.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.Enrollment VALUES (?,?,?,?)")){
            preparedStatement.setString(1, enrollment.getId());
            preparedStatement.setString(2, enrollment.getCourseId());
            preparedStatement.setString(3, enrollment.getStudentId());
            preparedStatement.setString(4, String.valueOf(enrollment.getGrade()));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return (result > 0);
    }

    @Override
    public boolean updateStudent(Student student) {
        return false;
    }
}
