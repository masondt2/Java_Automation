package NguyenTrungNgoc_JAVA_Assignment01;

import java.util.Scanner;
/*
Write a Java program that accepts two integer values from the user and return the larger values.
However,if the two values are the same, return 0 and return the smaller value if the two values have the same remainder
when divided by 6.
Sample Output:
Input the first number : 12
Input the second number: 13
Result: 13
 */

public class Exercise4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2, result;
        System.out.print("Input the first number: ");
        num1 = sc.nextInt();
        System.out.print("Input the second number: ");
        num2 = sc.nextInt();
        if (num1 == num2) {
            result = 0;
        }
        else {
            if (num1 % 6 == num2 % 6){
                result = (num1<num2) ? num1 : num2;
            }
            else {
                result = (num1>num2) ? num1 : num2;
            }
        }
        System.out.println("Result: "+ result);
        sc.close();
    }
}
