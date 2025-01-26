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

public class Emp {
    private int emp_id;
    private String name;
    double salary;
    char gender;
    private String department;
    private String emai_id;

    public Emp() {
    }

    public Emp(int emp_id, String name, double salary, char gender, String department, String emai_id) {
        this.emp_id = emp_id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.department = department;
        this.emai_id = emai_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmai_id() {
        return emai_id;
    }

    public void setEmai_id(String emai_id) {
        this.emai_id = emai_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "emp_id='" + emp_id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                ", department='" + department + '\'' +
                ", emai_id='" + emai_id + '\'' +
                '}';
    }
}
