package FinalProject.dao.Impl;

import FinalProject.dao.CourseDao;
import FinalProject.entity.Course;
import FinalProject.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class CourseDaoImpl implements CourseDao {
    @Override
    public boolean addCourse(Course course) {
        int result = 0;
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.Course VALUES (?,?,?)")) {
            preparedStatement.setString(1, course.getId());
            preparedStatement.setString(2, course.getTitle());
            preparedStatement.setInt(3, course.getCredits());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    @Override
    public boolean addListCourse(List<Course> Courses) {
        int result = 0;
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.Course VALUES (?,?,?)")) {
            connection.setAutoCommit(false);
            for (Course course : Courses) {
                preparedStatement.setString(1, course.getId());
                preparedStatement.setString(2, course.getTitle());
                preparedStatement.setInt(3, course.getCredits());
                preparedStatement.addBatch();
            }
            result = preparedStatement.executeBatch().length;
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    @Override
    public boolean updateCourseByTitle(Course course) {
        int result = 0;
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE dbo.Course SET credits = ? WHERE Title =?")) {
            preparedStatement.setInt(1, course.getCredits());
            preparedStatement.setString(2, course.getTitle());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    @Override
    public boolean deleteCourseByTitle(String title) {
        int result = 0;
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM dbo.Course WHERE Title =?")) {
            preparedStatement.setString(1, title);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    @Override
    public List<Course> getCourseByTitle(String title) throws SQLException {
        ResultSet result = null;
        List<Course> Courses = new ArrayList<>();
        try(Connection connection = DBUtils.getInstance().getConnection();
        Statement statement = connection.createStatement();){
            result = statement.executeQuery("SELECT * FROM dbo.Course WHERE Title like '%" + title + "%'");
            while (result.next()) {
                Course course = new Course(result.getString(1), result.getString(2), result.getInt(3));
                Courses.add(course);
            }
        }
        return Courses;
    }

    @Override
    public String updateCourseByCal(Course course) {
        String result = "";
        try(Connection connection = DBUtils.getInstance().getConnection();
        CallableStatement callableStatement = connection.prepareCall("{CALL updateCourseByCal(?,?,?,?)}")) {
            callableStatement.setString(1, course.getId());
            callableStatement.setString(2, course.getTitle());
            callableStatement.setInt(3, course.getCredits());
            callableStatement.registerOutParameter(4,Types.VARCHAR);
            callableStatement.execute();
            result = callableStatement.getString(4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addCourseRollback(Course course) {
        int result = 0;
        try(Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.Course VALUES (?,?,?)")) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, course.getId());
            preparedStatement.setString(2, course.getTitle());
            preparedStatement.setInt(3, course.getCredits());
            result = preparedStatement.executeUpdate();
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return result > 0;
    }
}
