package Homework;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Bạn sẽ viết một chương trình Java đế thực hiện các phép toán cơ bản trên hai số nguyên nhập vào từ người dùng.
Chương trình của bạn cần phải xử lý các ngoąi lệ sau:
- Ngoại lệ khi người dùng nhập vào giá trị không phài là số nguyên.
- Ngoại lệ khi người dùng nhập vào giá trį bằng 0 cho phép chia.
- Ngoại lệ khi số học có kết quả ngoài phạm vi của kiểu dữ liệu.
Yêu câu
Tạo một lớp Calculator với các phương thức sau:
- public int add(int a, int b): Thực hiện phép cộng hai số.
- public int subtract(int a, int b): Thực hiện phép trừ hai số.
- public int multiply (int a, int b): Thực hiện phép nhân hai số.
- public int divide(int a, int b) throws Arithmet icException: Thực hiện phép chia hai số và ném ngoại lệ


Tạo một lớp Main để nhập vào hai số từ người dùng và thực hiện các phép toán bằng cách sử dụng các phương thức của lớp
Calculator.

Xử lý các ngoại lệ sau:
- InputMismatchException khi người dùng nhập vào giá trị không phài là số nguyên.
- ArithmęticException khi chia cho 0.
- NumberformatException khi giá trị nhập vào không phài là số.
- OverflowException khỉ kết quả phép toán vượt quá phạm vi của kiểu dữ liệu int (nếu có)
 */
public class Calculator {
    private int a;
    private int b;

    public Calculator() {
    }

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int add() throws ArithmeticException {
        long result = this.getA() + this.getB();
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("OverflowException when adding");
        }
        return (int) result;
    }

    public int subtract() throws ArithmeticException {
        long result = this.getA() - this.getB();
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("OverflowException when Subtracting");
        }
        return (int) result;
    }

    public int multiply() throws ArithmeticException {
        long result = this.getA() * this.getB();
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("OverflowException when Multiplying");
        }
        return this.getA() * this.getB();
    }

    public int divide() throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        return this.getA() / this.getB();
    }
}


