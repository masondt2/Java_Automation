package unit10.dao;

import unit10.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    List<Course> findCourseByName(String name) throws SQLException;

    boolean saveCourse(Course course);
    
    String updateCourseWithCallableStatement(Course course);

    boolean updateCourse(Course course);

    boolean saveListCourse(List<Course> courses);

    boolean deleteCourse(String courseCode);
}
