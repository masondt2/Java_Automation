package Exercise1;

/*
Create a class named 'Student' with String variable 'name' and integer variable 'roll_no'.
Assign the value of
roll_no as '2' and that of name as "John" by creating an object of the class Student.
 */
public class Student {
    public String name;
    public int roll_no;

    //Method
    public void PrintInfor() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Roll Number: " + roll_no);
    }
}

class Main {
    public static void main(String[] args) {
        Student st1 = new Student();
        st1.name = "John";
        st1.roll_no = 2;
        st1.PrintInfor();
    }
}