package FinalProject.entity;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter

public class Course {
    private String id;
    private String title;
    private int credits;

    public Course() {
    }

    public Course(String courseId, String courseTitle, int credits) {
        this.id = courseId;
        this.title = courseTitle;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + id + '\'' +
                ", courseTitle='" + title + '\'' +
                ", credits=" + credits +
                '}';
    }
}
