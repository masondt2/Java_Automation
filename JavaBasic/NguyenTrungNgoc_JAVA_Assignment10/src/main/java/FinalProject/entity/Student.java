package FinalProject.entity;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter

public class Student {
    private String id;
    private String lastName;
    private String firstName;
    private Date enrollmentDate;

    public Student() {
    }

    public Student(String id, String lastName, String firstName, Date enrollmentDate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
