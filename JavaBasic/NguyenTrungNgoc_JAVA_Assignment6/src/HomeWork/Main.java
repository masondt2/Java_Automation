package HomeWork;
/*
Lớp Emp: Định nghĩa một lớp Emp với các trường sau:
 emp_id, name, salary, gender, department, và email_id.
  Định nghĩa các constructor, getter và setter tương ứng.
  Ghi đè phương thức toString() để hiển thị chi tiết của nhân viên.

Lớp EmpList: Định nghĩa một lớp EmpList có một ArrayList làm thành viên dữ liệu.
Trong lớp này, định nghĩa các phương thức:

- addEmp(Emp ob): Thêm một đối tượng Emp vào danh sách.
- deleteEmp(int eid): Xóa một đối tượng Emp khỏi danh sách bằng emp_id.
- displayMinSalary(): Hiển thị lương tối thiểu.
- displayMaxSalary(): Hiển thị lương tối đa.
- displayAverageSalary(): Hiển thị lương trung bình.
- searchEmp(int eid): Tìm kiếm một nhân viên sử dụng emp_id.
Phương thức main(): Kiểm thử chương trình bằng cách sử dụng phương thức main()
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpList empList = new EmpList();
        int choice = 0;
        do {
            System.out.println("Employee Management System");
            System.out.println("==========================");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Minimum of Salary");
            System.out.println("4. Maximum of Salary");
            System.out.println("5. Average of Salary");
            System.out.println("6. Search Employee");
            System.out.println("7. Display All Employees");
            System.out.println("8. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int emp_id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter employee name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary = sc.nextDouble();
                    System.out.print("Enter employee gender: ");
                    char gender = sc.next().charAt(0);
                    sc.nextLine();
                    System.out.print("Enter employee department: ");
                    String department = sc.nextLine();
                    System.out.print("Enter employee emai ID: ");
                    String email_id = sc.nextLine();
                    Emp em1 = new Emp(emp_id, name, salary, gender, department, email_id);
                    empList.addEmp(em1);
                    System.out.println("Employee added successfully!!!");
                    break;
                case 2:
                    System.out.print("Enter employee ID: ");
                    int eid = sc.nextInt();
                    empList.deleteEmp(eid);
                    break;
                case 3:
                    empList.displayMinSalary();
                    break;
                case 4:
                    empList.displayMaxSalary();
                    break;
                case 5:
                    empList.displayAverageSalary();
                    break;
                case 6:
                    System.out.print("Enter employee ID want to find: ");
                    int emIdFind = sc.nextInt();
                    Emp foundEmp = empList.searchEmp(emIdFind);
                    if (foundEmp != null) {
                        System.out.println("It's Found!!!");
                        System.out.println(foundEmp.toString());
                    } else {
                        System.out.println("Employee Not Found!!!");
                    }
                    break;
                case 7:
                    System.out.println("List of Employees: ");
                    empList.displayEmpList();
                    break;
                default:
                    break;
            }
        } while (choice != 8);
        sc.close();
    }
}
