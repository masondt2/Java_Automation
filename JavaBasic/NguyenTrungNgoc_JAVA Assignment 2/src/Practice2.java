import java.util.Scanner;

/*
        Viết chương trình cho phép nhập vào một số nguyên dương n,
         tính tổng tất cả số chẵn trong khoảng từ 0 - n.
         */
public class Practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag = 0, sum = 0, n;
        do {
            System.out.print("Input the number n>0: ");
            n = sc.nextInt();
            if (n > 0) {
                flag = 1;
                for (int i = 0; i <= n; i++) {
                    if (i % 2 == 0) {
                        sum += i;
                    }
                }
            } else {
                System.out.println("The number is invalid, please try again!!! ");
            }
        } while (flag == 0);
        System.out.printf("The sum of even numbers in the range (0 ~ %d) is: %d", n, sum);
        sc.close();
    }
}
