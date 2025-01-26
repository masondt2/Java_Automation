package NguyenTrungNgoc_JAVA_Assignment01;
/*
Write a Java program to multiply two binary numbers.
Input Data:
Input the first binary number: 10
Input the second binary number: 11
Expected Output
Product of two binary numbers: 110
 */
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the first binary number: ");
        String bin1 = sc.nextLine();
        System.out.print("Input the second binary number: ");
        String bin2 = sc.nextLine();

        //Convert binary strings to integer
        int num1 = Integer.parseInt(bin1,2);
        int num2 = Integer.parseInt(bin2,2);
        int multi = num1*num2;

        //Convert integer to binary strings
        String result = Integer.toBinaryString(multi);

        System.out.println("Product of two binary numbers: "+result);
        sc.close();
    }
}
