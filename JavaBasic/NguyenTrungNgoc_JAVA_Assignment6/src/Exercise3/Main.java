package Exercise3;

import java.util.Scanner;

/*
/*
Write a Java program to create a Stack data structure.
This Stack data structure is to store the integer values.
Your program should display a menu of choices to operate the Stack data structure.
See the sample menu below:
==================================================
Stack Operations Menu
==================================================
1. Add items
2. Delete items
3. Show the number of items
4. Show min and max items
5. Find an item
6. Print all items
7. Exit
Enter your choice:1
 */
public class Main {
    public static void main(String[] args) {
        StackData stackData = new StackData();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("==================================================");
            System.out.println("Stack Operations Menu");
            System.out.println("==================================================");
            System.out.println("1. Add items");
            System.out.println("2. Delete items");
            System.out.println("3. Show the number of items");
            System.out.println("4. Show min and max items");
            System.out.println("5. Find an item");
            System.out.println("6. Print all items");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter an integer to add: ");
                    int valueToAdd = sc.nextInt();
                    stackData.push(valueToAdd);
                    System.out.println("Item added successfully");
                    break;
                case 2:
                    Integer removeItem = stackData.pop();
                    if (removeItem != null) {
                        System.out.println("Removed item: " + removeItem);
                    }
                    System.out.println("Item deleted successfully");
                    break;
                case 3:
                    System.out.println("Number of items in stack: " + stackData.Size());
                    break;
                case 4:
                    Integer minItem = stackData.getMin();
                    Integer maxItem = stackData.getMax();
                    System.out.println("Minimum item: " + (minItem != null ? minItem : "Stack is Empty"));
                    System.out.println("Maximum item: " + (maxItem != null ? maxItem : "Stack is Empty"));
                    break;
                case 5:
                    System.out.print("Enter an integer to find in stack: ");
                    int findItem = sc.nextInt();
                    if (stackData.FindItem(findItem)) {
                        System.out.println("Item " + findItem + " is found in stack");
                    } else {
                        System.out.println("Item " + findItem + " is not found in stack");
                    }
                    break;
                case 6:
                    stackData.PrintStack();
                    break;
                case 7:
                    System.out.println("Goodbye!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
            ;
        } while (choice != 7);
        sc.close();
    }
}
