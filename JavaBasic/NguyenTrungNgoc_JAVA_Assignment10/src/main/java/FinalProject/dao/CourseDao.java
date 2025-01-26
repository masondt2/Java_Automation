package FinalProject.dao;

import FinalProject.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    boolean addCourse(Course course);

    boolean addListCourse(List<Course> listCourse);

    boolean updateCourseByTitle(Course course);

    boolean deleteCourseByTitle(String title);

    List<Course> getCourseByTitle(String title) throws SQLException;

    String updateCourseByCal(Course course);

    boolean addCourseRollback(Course course);
}
