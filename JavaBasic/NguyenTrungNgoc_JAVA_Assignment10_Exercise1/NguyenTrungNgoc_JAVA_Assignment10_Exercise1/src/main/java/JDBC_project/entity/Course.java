package JDBC_project.entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class Course {
    private String courseId;
    private String courseTitle;
    private int Credit;

    public Course() {
    }

    public Course(String courseId, String courseTitle, int credit) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        Credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", Credit=" + Credit +
                '}';
    }
}
