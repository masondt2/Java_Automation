package exercise3;

public class ShapeTest {
    public static void main(String[] args) {
        // Using polymorphism
        Shape circle = new Circle(5);
        Shape Rectangle = new Rectangle(5, 6);
        Shape Square = new Square(5);
        System.out.println(circle);
        System.out.println("Circle Area: " + circle.getArea());
        System.out.println("Circle Perimeter: " + circle.getPerimeter());
        System.out.println();
        System.out.println(Rectangle);
        System.out.println("Rectangle Area: " + Rectangle.getArea());
        System.out.println("Rectangle Perimeter: " + Rectangle.getPerimeter());
        System.out.println();
        System.out.println(Square);
        System.out.println("Square Area: " + Square.getArea());
        System.out.println("Square Perimeter: " + Square.getPerimeter());
    }
}
