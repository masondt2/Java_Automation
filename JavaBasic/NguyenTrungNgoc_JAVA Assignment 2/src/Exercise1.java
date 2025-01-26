import java.util.Scanner;

/*
Write a Java program that reads a floating-point number and prints &quot;zero&quot;
if the number is zero.
Otherwise,print 'positive'; or 'negative'.
Add 'small' if the absolute value of the number is less than 1, or 'large&qu if it
exceeds 1,000,000.
Test Data
Input a number: 25
Expected Output :
Input value: 25
Positive number
 */
public class Exercise1 {
    public static void addInfor(double n){
        if (Math.abs(n)<1){
            System.out.println("small");
        }
        else if (Math.abs(n)>1000000){
            System.out.println("large");
        }
    }
    public static void main(String[] args) {
        double n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number: ");
        n = sc.nextDouble();
        sc.close();
        if (n==0){
            System.out.println("Input value: "+n);
            System.out.println("zero");
        }
        else if (n>0){
            System.out.println("Input value: "+n);
            System.out.println("Positive number");
            addInfor(n);
        }
        else {
            System.out.println("Input value: "+n);
            System.out.println("Negative number");
            addInfor(n);
        }

    }
}
