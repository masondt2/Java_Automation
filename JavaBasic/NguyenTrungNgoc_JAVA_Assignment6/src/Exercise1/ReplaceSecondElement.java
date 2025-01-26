package Exercise1;
/*
Write a Java program to replace the second element of a ArrayList with the specified element.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReplaceSecondElement {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Ha Noi", "TP Ho Chi Minh", "Da Nang", "Nha Trang", "Phu Quoc"));
        System.out.println("The original list is: " + list);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the element to be replaced: ");
        String replaceElement = sc.nextLine();
        if (list.size() > 1) {
            list.set(1, replaceElement);
        } else {
            System.out.println("The list does not have the Second element to replace.");
        }
        System.out.println("The Modified list is: " + list);
        sc.close();
    }
}
