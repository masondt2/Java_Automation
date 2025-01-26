package Exercise1;

/*
Write a program to print the names of students
 by creating a Student class.
 If no name is passed while creating an object of Student class,
 then the name should be "Unknown",
 otherwise the name should be equal to the String value passed while creating object of Student class.
 */
public class Student {
    private String name;

    public Student() {
        this.name = "Unknown";
    }

    public Student(String name) {
        if (name == null || name.isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

}

class Main {
    public static void main(String[] args) {
        Student st1 = new Student();
        System.out.println("Name of student: " + st1.getName());
        Student st2 = new Student("Ngoc");
        System.out.println("Name of student: " + st2.getName());
    }
}
