package FinalProject.entity;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter

public class Enrollment {
    private String id;
    private String courseId;
    private String studentId;
    private String grade;

    public Enrollment() {
    }

    public Enrollment(String id, String courseId, String studentId, String grade) {
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
