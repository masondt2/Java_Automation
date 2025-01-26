package exercise2;
/*
Create A class called Student with 3 properties “First, Last, Email”.
Write a Java program to read and write a object Student to file.
 */

import java.io.Serializable;

public class Student implements Serializable {
    private final String first;
    private final String last;
    private final String email;

    public Student(String first, String last, String email) {
        this.first = first;
        this.last = last;
        this.email = email;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

