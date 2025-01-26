package problem2.management;

import problem2.dao.TraineeDao;
import problem2.entities.Trainee;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TraineeManagement {
    public static void main(String[] args) {
        TraineeDao traineeDao = new TraineeDao();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=============FA System===========");
            System.out.println("1. Creat Trainee");
            System.out.println("2. Update Trainee");
            System.out.println("3. Remove a specific Trainee");
            System.out.println("4. Report incomplete training");
            System.out.println("5. List excellent trainees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1~6): ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("---------Create Trainee---------");
                    System.out.print("Enter account: ");
                    String account = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter gender: ");
                    boolean gender = scanner.nextBoolean();
                    scanner.nextLine();
                    System.out.print("Enter birth date: ");
                    String birthDate = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter gpa: ");
                    String gpa = scanner.nextLine();
                    System.out.print("Enter status (active / in-active): ");
                    String status = scanner.nextLine();
                    Trainee trainee = new Trainee(account, name, gender, Date.valueOf(birthDate), phone, gpa, status);
                    if (traineeDao.save(trainee)) {
                        System.out.println("Add successfully.");
                    } else {
                        System.out.println("Add Failed.");
                    }
                    break;
                case 2:
                    System.out.println("---------Update Trainee---------");
                    System.out.print("Enter account want to update: ");
                    String account1 = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter gender: ");
                    boolean gender1 = scanner.nextBoolean();
                    scanner.nextLine();
                    System.out.print("Enter birth date: ");
                    String birthDate1 = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone1 = scanner.nextLine();
                    System.out.print("Enter gpa: ");
                    String gpa1 = scanner.nextLine();
                    System.out.print("Enter status (active / in-active): ");
                    String status1 = scanner.nextLine();
                    Trainee trainee1 = new Trainee(account1, name1, gender1, Date.valueOf(birthDate1), phone1, gpa1, status1);
                    if (traineeDao.update(trainee1)) {
                        System.out.println("Update successfully.");
                    } else {
                        System.out.println("Update Failed.");
                    }
                    break;
                case 3:
                    System.out.println("---------Remove Trainee---------");
                    System.out.println("Enter account: ");
                    String accountRemove = scanner.nextLine();
                    if (traineeDao.remove()) {
                        System.out.println("Remove successfully.");
                    } else {
                        System.out.println("Remove Failed.");
                    }
                    break;
                case 4:
                    System.out.println("Incomplete training list: ");
                    List<Trainee> traineeListInComplete = new ArrayList<>();
                    traineeListInComplete = traineeDao.findIncompletedTrainee();
                    for (Trainee tr : traineeListInComplete) {
                        System.out.println(tr);
                    }
                    break;
                case 5:
                    System.out.println("Excellent Trainees: ");
                    List<Trainee> traineeExellent = new ArrayList<>();
                    traineeExellent = traineeDao.findExcellentTrainee();
                    for (Trainee tr : traineeExellent) {
                        System.out.println(tr);
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid chose, please try again.");
            }
        } while (true);
    }
}
