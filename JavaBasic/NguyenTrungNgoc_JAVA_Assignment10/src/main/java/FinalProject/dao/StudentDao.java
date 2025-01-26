package FinalProject.dao;

import FinalProject.entity.Student;

public interface StudentDao {
    boolean addStudent(Student student);

    boolean updateStudentByFirstName(Student student);
}
