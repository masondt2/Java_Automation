import java.util.Scanner;

/*
Compute the natural logarithm of 2, by adding up to n terms in the series
1 - 1/2 + 1/3 - 1/4 + 1/5 -... 1/n
where n is a positive integer and input by user.
 */
public class Exercise5 {
    public static void main(String[] args) {
        int n;
        double result = 0.0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        n = sc.nextInt();
        sc.close();
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                result = result + 1.0/i;
            }
            else {
                result = result - 1.0/i;
            }
        }
        System.out.printf("The natural logarithm of 2 of %d is: %f", n, result);
    }
}

