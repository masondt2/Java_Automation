package homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    public static Scanner sc = new Scanner(System.in);
    static String file_path = "Employee.txt";

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    searchEmployeeById();
                    break;
                case 4:
                    deleteEmployeeById();
                    break;
                case 5:
                    System.out.println("Goodbye!!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    public static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Salary: ");
        float salary = sc.nextFloat();
        sc.nextLine(); // Consume newline

        Employee employee = new Employee(id, name, age, salary);
        List<Employee> employees = readEmployees();

        employees.add(employee);
        writeEmployees(employees);
        System.out.println("Employee added successfully.");
    }

    public static void displayAllEmployees() {
        List<Employee> employees = readEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public static void searchEmployeeById() {
        System.out.print("Enter Employee ID to search: ");
        String id = sc.nextLine();
        List<Employee> employees = readEmployees();
        boolean found = false;

        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(id)) {
                System.out.println(employee);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    public static void deleteEmployeeById() {
        System.out.print("Enter Employee ID to delete: ");
        String id = sc.nextLine();
        List<Employee> employees = readEmployees();
        boolean removed = employees.removeIf(employee -> employee.getEmployeeId().equals(id));

        if (removed) {
            writeEmployees(employees);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void writeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file_path))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    public static List<Employee> readEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_path))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Return an empty list if there is an error
        }
    }
}
