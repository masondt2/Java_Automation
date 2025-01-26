package JDBC_project.entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private Date enrollmentDate;

    public Student() {
    }

    public Student(String studentId, String firstName, String lastName, Date enrollmentDate) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
