package Exercise4;
/*
Write a program by creating an 'Employee' class having the following methods
and print the final salary.
1 - 'getInfo()' which takes the salary, number of hours of work per day of employee as parameter
2 - 'AddSal()' which adds $10 to salary of the employee if it is less than $500.
3 - 'AddWork()' which adds $5 to salary of employee
if the number of hours of work per day is more than 6 hours.
 */

public class Employee {
    private double salary;
    private int workHour;

    public Employee() {
        salary = 0;
        workHour = 0;
    }

    public void getInfor(double salary, int workHour) {
        this.salary = salary;
        this.workHour = workHour;
    }

    public void AddSal() {
        if (salary < 500) {
            salary += 10;
        }
    }

    public void AddWork() {
        if (workHour > 6) {
            salary += 5;
        }
    }

    public double getFinalSalary() {
        AddSal();
        AddWork();
        return salary;
    }
}

class Main {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.getInfor(450, 7);
        System.out.println("The final of Salary of Employee is " + emp.getFinalSalary());
    }
}
