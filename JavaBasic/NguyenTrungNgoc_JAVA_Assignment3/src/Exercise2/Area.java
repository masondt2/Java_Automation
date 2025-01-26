package Exercise2;
/*
Write a program to print the area of a rectangle
by creating a class named 'Area'
taking the values of its length and breadth as parameters of its constructor
and having a method named 'returnArea' which returns the area
of the rectangle. Length and breadth of rectangle are entered through keyboard.
 */

import java.util.Scanner;

public class Area {
    double leng, breadth;

    //Constructor
    public Area(double leng, double breadth) {
        this.leng = leng;
        this.breadth = breadth;
    }

    //Method
    public double returnArea() {
        return leng * breadth;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the leng: ");
        double l1 = sc.nextDouble();
        System.out.print("Enter the breadth: ");
        double b1 = sc.nextDouble();
        Area area1 = new Area(l1, b1);
        System.out.println("Area of rectangle: " + area1.returnArea());
        sc.close();
    }
}
