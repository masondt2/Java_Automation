package JDBC_project.entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class Enrollment {
    private String id;
    private String courseId;
    private String studentId;
    private char grade;

    public Enrollment() {
    }

    public Enrollment(String id, String courseId, String studentId, char grade) {
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id='" + id + '\'' +
                ", courseId='" + courseId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", grade=" + grade +
                '}';
    }
}
