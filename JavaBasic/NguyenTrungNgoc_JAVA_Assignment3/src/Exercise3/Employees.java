package Exercise3;

/*
Write a program that would print the information
(name, year of joining, salary, address) of three employees
by creating a class named 'Employee'. The output should be as follows:
Name Year of joining Address
Robert 1994 64C- WallsStreat
Sam 2000 68D- WallsStreat
John 1999 26B- WallsStreat
 */
public class Employees {
    String name, address;
    int yearOfJoin;
    double salary;

    //Constructor
    public Employees(String name, int yearOfJoin, String address) {
        this.name = name;
        this.yearOfJoin = yearOfJoin;
        this.address = address;
    }

    //Method
    public void getInfor() {
        System.out.printf("%s %18d %30s\n", name, yearOfJoin, address);
    }

}

class Main {
    public static void main(String[] args) {
        System.out.printf("Name %-10s Year of joining %-10s Address\n", " ", " ");
        Employees emp1 = new Employees("Robert", 1994, "64C- WallsStreat");
        Employees emp2 = new Employees("Sam", 2000, "68D- WallsStreat");
        Employees emp3 = new Employees("John", 1999, "26B- WallsStreat");
        emp1.getInfor();
        emp2.getInfor();
        emp3.getInfor();
    }
}