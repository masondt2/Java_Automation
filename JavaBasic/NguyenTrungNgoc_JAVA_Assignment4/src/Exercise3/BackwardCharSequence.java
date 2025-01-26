package Exercise3;
/*
Write a class that implements the CharSequence interface found in the java.lang package. Your
implementation should return the string backwards. Select one of the sentences from this book to use as the
data. Write a small main method to test your class; make sure to call all four methods.
 */

import java.util.stream.IntStream;

public class BackwardCharSequence implements CharSequence {
    private String data;

    public BackwardCharSequence(String data) {
        this.data = data;
    }

    @Override
    public int length() {
        return this.data.length();
    }

    @Override
    //return char at the backward index
    public char charAt(int index) {
        return data.charAt(data.length() - 1 - index);
    }

    @Override
    //return the backward sequence
    public CharSequence subSequence(int start, int end) {
        StringBuilder sb = new StringBuilder(data.subSequence(start, end));
        return sb.reverse();
    }

    @Override
    //return the backward sequence
    public String toString() {
        StringBuilder sb = new StringBuilder(data);
        return sb.reverse().toString();
    }
}

class Main {
    public static void main(String[] args) {
        String stringtest = "Hello my name is Ngoc";
        BackwardCharSequence backwardSequence = new BackwardCharSequence(stringtest);
        System.out.println("Original string: " + stringtest);
        System.out.println("Length of string: " + backwardSequence.length());
        System.out.print("Reversed Characters: ");
        for (int i = 0; i < backwardSequence.length(); i++) {
            System.out.print(backwardSequence.charAt(i));
        }
        System.out.println();
        System.out.println("Reversed Substring  from index 0 to 5: " + backwardSequence.subSequence(0, 5));
        System.out.println("Reversed String: " + backwardSequence.toString());
    }
}
