import java.util.Scanner;

/*
Write a program in Java to display the cube of the number upto given an integer.
Test Data
Input number of terms : 4
Expected Output :

Number is : 1 and cube of 1 is : 1
Number is : 2 and cube of 2 is : 8
Number is : 3 and cube of 3 is : 27
Number is : 4 and cube of 4 is : 64
 */
public class Exercise2 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of terms: ");
        n = sc.nextInt();
        sc.close();
        for (int i = 1; i <= n; i++) {
            System.out.printf("Number is: %d and cube of %d is: %d\n",i,i,i*i*i);
        }
    }
}
