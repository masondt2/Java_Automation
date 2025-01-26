package unit10;

import unit10.dao.CourseDao;
import unit10.dao.impl.CourseDAOImpl;
import unit10.entity.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseTest {
    public static void main(String[] args) throws SQLException {
        CourseDao courseDao = new CourseDAOImpl();

//        getCourse(courseDao);
//        saveCourse(courseDao);
//        getCourse(courseDao);
//        updateCourse(courseDao);
        saveListCourse(courseDao);
//        deleteCourse(courseDao);
    }

    public static void getCourse(CourseDao courseDao) {
        String name = "Angular";

        try {
            List<Course> courses = courseDao.findCourseByName(name);
            courses.forEach(c -> System.out.println(c));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveCourse(CourseDao courseDao) {
        Course course = new Course("902", "ITC", "1205",
                "Java SE Programming Language", 5);

        if (courseDao.saveCourse(course)) {
            System.out.println("Save success!!");
        } else {
            System.out.println("Save false!!");
        }
    }

    public static void updateCourse(CourseDao courseDao) {
        Course course = new Course("JV011", "Java", "1205",
                "Java SE1", 12);

        if (courseDao.updateCourse(course)) {
            System.out.println("Update success!!");
        } else {
            System.out.println("Update false!!");
        }

//        System.out.println(courseDao.updateCourseWithCallableStatement(course));
    }

    public static void saveListCourse(CourseDao courseDao) {
        Course course1 = new Course("900", "Java", "1206",
                "Java SE 1", 11);
        Course course2 = new Course("901", "Java", "1207",
                "Java SE 2", 12);

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        System.out.println(courseDao.saveListCourse(courses));
    }

    public static void deleteCourse(CourseDao courseDao) {
        if (courseDao.deleteCourse("1205")) {
            System.out.println("Delete success!!");
        } else {
            System.out.println("Delete false!!");
        }
    }
}
