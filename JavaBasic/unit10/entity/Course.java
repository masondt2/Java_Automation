package unit10.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    private String courseId;
    private String subjectId;
    private String courseCode;
    private String courseTitle;
    private int numOfCredit;

    public Course() {
    }

    public Course(String courseId, String subjectId, String courseCode, String courseTitle, int numOfCredit) {
        this.courseId = courseId;
        this.subjectId = subjectId;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.numOfCredit = numOfCredit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", numOfCredit=" + numOfCredit +
                '}';
    }
}
