import java.util.Scanner;

/*
Có 2 số là num1 và num2 do người dùng nhập vào để tính,
các phép tính +, -, *, /
cũng do người dùng nhập vào để thực hiện phép tính mà họ muốn.
 */
public class Practice1 {
    public static void main(String[] args) {
        double num1, num2, flag = 0;
        char operator;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Number: ");
        num1 = sc.nextDouble();
        System.out.print("Enter Second Number: ");
        num2 = sc.nextDouble();
        while(flag == 0){
            System.out.print("Enter Operator (+, -, *, /): ");
            operator = sc.next().charAt(0);
            switch(operator){
                case '+':
                    flag = 1;
                    System.out.println("The Sum is " + num1 + " + " + num2 + " = " + (num1 + num2));
                    break;
                case '-':
                    flag = 1;
                    System.out.println("The Subtraction is " + num1 + " - " + num2 + " = " + (num1 - num2));
                    break;
                case '*':
                    flag = 1;
                    System.out.println("The Multiplication is " + num1 + " * " + num2 + " = " + (num1 * num2));
                    break;
                case '/':
                    flag = 1;
                    if (num2!=0) {
                        System.out.println("The Division is " + num1 + " / " + num2 + " = " + (num1 / num2));
                    }
                    else {
                        System.out.println("Error: Division by zero!!!");
                    }
                    break;
                default:
                    System.out.println("Invalid Operator, please try again !!!");
            }
        }
        sc.close();
    }
}
