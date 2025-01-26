package exercise2;

import java.io.*;

public class StudentFile {
    static final String FILE_PATH = "student.txt";

    public static void main(String[] args) {
        Student student = new Student("Nguyen", "Trung Ngoc", "trungngoc@gmail.com");

        // Write the Student object to a file
        writeStudentToFile(student);

        // Read the Student object from the file
        Student readStudent = readStudentFromFile();
        System.out.println("Read Student: " + readStudent);

    }

    public static void writeStudentToFile(Student student) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(student);
            System.out.println("Student object has been serialized to " + FILE_PATH);

        } catch (IOException e) {
            System.out.println("Error writing to file " + FILE_PATH);
        }
    }

    private static Student readStudentFromFile() {
        Student student = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            student = (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error in reading file " + FILE_PATH);
        }
        return student;
    }
}
