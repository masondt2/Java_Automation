package HomeWork;

import java.util.ArrayList;

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
public class EmpList {
    private ArrayList<Emp> empList;

    public EmpList() {
        this.empList = new ArrayList<>();
    }

    public EmpList(ArrayList<Emp> empList) {
        this.empList = empList;
    }

    public void addEmp(Emp emp) {
        this.empList.add(emp);
    }

    public void displayEmpList() {
        for (Emp emp : empList) {
            System.out.println(emp.toString());
        }
    }

    public void deleteEmp(int eid) {
        int flag = 0;
        for (Emp emp : empList) {
            if (emp.getEmp_id() == eid) {
                empList.remove(emp);
                flag = 1;
                System.out.println("Deleted successfully");
            }
        }
        if (flag == 0) {
            System.out.println("Emp not found");
        }
    }

    public void displayMinSalary() {
        if (empList.isEmpty()) {
            System.out.println("Employee list is empty");
        }
        double minTemp = empList.get(0).getSalary();
        for (Emp emp : empList) {
            if (emp.getSalary() < minTemp) {
                minTemp = emp.getSalary();
            }
        }
        System.out.println("Min Salary: " + minTemp);
    }

    public void displayMaxSalary() {
        if (empList.isEmpty()) {
            System.out.println("Employee list is empty");
        }
        double maxTemp = empList.get(0).getSalary();
        for (Emp emp : empList) {
            if (emp.getSalary() > maxTemp) {
                maxTemp = emp.getSalary();
            }
        }
        System.out.println("Max Salary: " + maxTemp);
    }

    public void displayAverageSalary() {
        if (empList.isEmpty()) {
            System.out.println("Employee list is empty");
        }
        double totalSalary = 0;
        for (Emp emp : empList) {
            totalSalary += emp.getSalary();
        }
        System.out.println("Average Salary: " + totalSalary / empList.size());
    }

    public Emp searchEmp(int eid) {
        for (Emp emp : empList) {
            if (emp.getEmp_id() == eid) {
                return emp;
            }
        }
        return null;
    }


}




