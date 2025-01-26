package JDBC_project.dao;

import JDBC_project.entity.Course;
import JDBC_project.entity.Enrollment;
import JDBC_project.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface CourseManagenmentDao
{
        boolean saveCourse(Course course);

        boolean saveStudent(Student student);

        boolean saveEnrollment(Enrollment enrollment);

        boolean updateStudent(Student student);

}
