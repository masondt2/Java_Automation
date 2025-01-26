package Exercise2;

/*
Write an application that stores the integer numbers between 1 (included) and 64 (included) in an array
and prints them in a reverse order.
 */
public class ReverseArrayInt {
    public static void main(String[] args) {
        int[] arr = new int[64];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println("Array with reverse Number: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

}
