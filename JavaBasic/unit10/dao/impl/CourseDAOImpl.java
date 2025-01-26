package unit10.dao.impl;

import unit10.dao.CourseDao;
import unit10.entity.Course;
import unit10.utils.DBUtils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDao {

    @Override
    public List<Course> findCourseByName(String name) throws SQLException {
        ResultSet result = null;

        List<Course> courses = new ArrayList<>();

        try (Connection connection = DBUtils.getInstance().getConnection();

             // 3. Create statement
             Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                     ResultSet.CONCUR_READ_ONLY)) {
            // 4. Execute statement
            result = statement.executeQuery(
                    "SELECT * FROM dbo.Course WHERE course_title LIKE '%" + name + "%'");

            Course course;
            while (result.next()) {
                course = new Course(result.getString(1), result.getString(2),
                        result.getString(3), result.getString(4), result.getInt(5));
                courses.add(course);
            }
        }
        return courses;
    }

    @Override
    public boolean saveCourse(Course course) {
        int result = 0;
        try (Connection connection = DBUtils.getInstance().getConnection();

             // 3. Create statement
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.Course VALUES (?,?,?,?,?)")) {
            preparedStatement.setString(1, course.getCourseId());
            preparedStatement.setString(2, course.getSubjectId());
            preparedStatement.setString(3, course.getCourseCode());
            preparedStatement.setString(4, course.getCourseTitle());
            preparedStatement.setInt(5, course.getNumOfCredit());

            // 4. Execute statement
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (result > 0);
    }

    @Override
    public String updateCourseWithCallableStatement(Course course) {
        String result = "";
        try (Connection connection = DBUtils.getInstance().getConnection();

             // 3. Create statement
             CallableStatement callableStatement = connection.prepareCall("{CALL usp_UpdateCourse(?,?,?,?,?,?)}")) {
            callableStatement.setString(1, course.getCourseId());
            callableStatement.setString(2, course.getSubjectId());
            callableStatement.setString(3, course.getCourseCode());
            callableStatement.setString(4, course.getCourseTitle());
            callableStatement.setInt(5, course.getNumOfCredit());
            callableStatement.registerOutParameter(6, Types.VARCHAR);

            // 4. Execute statement
            callableStatement.execute();
            result = callableStatement.getString(6);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean updateCourse(Course course) {
        int result = 0;
        try (Connection connection = DBUtils.getInstance().getConnection();

             // 3. Create statement
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE dbo.Course SET subject_id = ?, course_title = ?, num_of_credits = ? WHERE course_code = ?")) {
            preparedStatement.setString(1, course.getSubjectId());
            preparedStatement.setString(2, course.getCourseTitle());
            preparedStatement.setInt(3, course.getNumOfCredit());
            preparedStatement.setString(4, course.getCourseCode());

            // 4. Execute statement
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (result > 0);
    }

    @Override
    public boolean saveListCourse(List<Course> courses) {
        int result = 0;
        try (Connection connection = DBUtils.getInstance().getConnection();
             // 3. Create statement
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.Course VALUES (?,?,?,?,?)");
        ) {
            connection.setAutoCommit(false);

            for (Course course : courses) {
                preparedStatement.setString(1, course.getCourseId());
                preparedStatement.setString(2, course.getSubjectId());
                preparedStatement.setString(3, course.getCourseCode());
                preparedStatement.setString(4, course.getCourseTitle());
                preparedStatement.setInt(5, course.getNumOfCredit());

                preparedStatement.addBatch();
            }

            // 4. Execute statement
            result = preparedStatement.executeBatch().length;

            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result > 0;
    }

    @Override
    public boolean deleteCourse(String courseCode) {
        int result = 0;
        try (Connection connection = DBUtils.getInstance().getConnection();

             // 3. Create statement
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM dbo.Course WHERE course_code = ?")) {
            preparedStatement.setString(1, courseCode);

            // 4. Execute statement
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (result > 0);
    }
}
