package FinalProject;

import FinalProject.dao.CourseDao;
import FinalProject.dao.EnrollmentDao;
import FinalProject.dao.Impl.CourseDaoImpl;
import FinalProject.dao.Impl.EnrollmentDaoImpl;
import FinalProject.dao.Impl.StudentDaoImpl;
import FinalProject.dao.StudentDao;
import FinalProject.entity.Course;
import FinalProject.entity.Enrollment;
import FinalProject.entity.Student;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CourseDao courseDao = new CourseDaoImpl();
        StudentDao studentDao = new StudentDaoImpl();
        EnrollmentDao enrollmentDao = new EnrollmentDaoImpl();
        //addCourse(courseDao);
        //addStudent(studentDao);
        //addEnrollment(enrollmentDao);
        //addListCourse(courseDao);
        //updateCourseByTitle(courseDao);
        updateStudentByFirstName(studentDao);
        //deleteCourseByTitle(courseDao);
        //getCourseByTitle(courseDao);
        //addCourseRollback(courseDao);

    }

    public static void addCourse(CourseDao courseDao){
        Course course = new Course("5","Math2",5);
        if(courseDao.addCourse(course)){
            System.out.println("Course added successfully");
        }
        else{
            System.out.println("Course added failed");
        }
    }

    public static void addStudent(StudentDao studentDao){
        Student student = new Student("4","Le","Van Long", Date.valueOf("2022-07-10"));
        if(studentDao.addStudent(student)){
            System.out.println("Student added successfully");
        }
        else {
            System.out.println("Student added failed");
        }
    }

    public static void addEnrollment(EnrollmentDao enrollmentDao){
        Enrollment enrollment = new Enrollment("4","1","3","A");
        if(enrollmentDao.addEnrollment(enrollment)){
            System.out.println("Enrollment added successfully");
        }
        else{
            System.out.println("Enrollment added failed");
        }
    }

    public static void addListCourse(CourseDao courseDao){
        List<Course> courses = new ArrayList<>();
        Course course1 = new Course("6","C++2",3);
        Course course2 = new Course("7","C++3",3);
        courses.add(course1);
        courses.add(course2);
        if(courseDao.addListCourse(courses)){
            System.out.println("List Courses added successfully");
        }
        else {
            System.out.println("List Courses added failed");
        }
    }

    public static void updateCourseByTitle(CourseDao courseDao){
        Course course = new Course("xxx","C++",10);
        if(courseDao.updateCourseByTitle(course)){
            System.out.println("Course updated successfully");
        }
        else {
            System.out.println("Course updated failed");
        }
    }

    public static void updateStudentByFirstName(StudentDao studentDao){
        Student student = new Student("xxx","xxx","Le",Date.valueOf("2024-04-10"));
        if(studentDao.updateStudentByFirstName(student)){
            System.out.println("Student updated successfully");
        }
        else{
            System.out.println("Student updated failed");
        }
    }

    public static void deleteCourseByTitle(CourseDao courseDao){
        String title = "TestRollback";
        if(courseDao.deleteCourseByTitle(title)){
            System.out.println("Course deleted successfully");
        }
        else {
            System.out.println("Course deleted failed");
        }
    }

    public static void getCourseByTitle(CourseDao courseDao){
        String title = "C";
        List<Course> courses = new ArrayList<>();
        try {
            courses = courseDao.getCourseByTitle(title);
            for (Course course : courses) {
                System.out.println(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCourseByCal(CourseDao courseDao){
        Course course =new Course("xx","Math",6);
        System.out.println(courseDao.updateCourseByCal(course));
    }

    public static void addCourseRollback(CourseDao courseDao){
        Course course = new Course("6","TestRollback",1);
        if(courseDao.addCourseRollback(course)){
            System.out.println("Course added successfully.");
        }
        else {
            System.out.println("Course added Failed");
        }
    }
}
