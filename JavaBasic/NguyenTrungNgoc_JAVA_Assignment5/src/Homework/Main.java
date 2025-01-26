package Homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter the first number: ");
            int a = sc.nextInt();
            System.out.print("Enter the second number: ");
            int b = sc.nextInt();
            Calculator calc = new Calculator(a, b);
            System.out.println("Addition: a+b= "+calc.add());
            System.out.println("Subtration: a-b= "+calc.subtract());
            System.out.println("Multiplication: a*b= "+calc.multiply());
            System.out.println("Division: a/b= "+calc.divide());
        }catch (InputMismatchException e) {
            System.out.println("Inputted number is not a Interger number.");
        }catch (ArithmeticException e) {
            System.out.println("Arithmetic error. Devide by zero!");
        }catch (NumberFormatException e) {
            System.out.println("Inputted data is not a number.");
        }catch (Exception e) {
            System.out.println("OverflowException");
        }
        finally {
            sc.close();
        }
    }
}
