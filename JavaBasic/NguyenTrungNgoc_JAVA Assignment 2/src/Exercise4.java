/*
Write a program to print out all Armstrong numbers between 1 and 500.
If sum of cubes of each digit of the
number is equal to the number itself, then the number is called an Armstrong number.
For example, 153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 )
 */
public class Exercise4 {
    public static boolean IsArmstrongNumber(int number) {
        int originalNum = number;
        int remainderNum, result = 0;
        //Check how many digits that the number have:
        int numDigit = String.valueOf(number).length();
        while (originalNum != 0) {
            remainderNum = originalNum % 10;
            result += (int) Math.pow(remainderNum,numDigit);
            originalNum /= 10;
        }
        return result == number;
    }
    public static void main(String[] args) {
        for (int i = 1; i<=500; i++){
            if (IsArmstrongNumber(i)){
                System.out.println(i);
            }
        }
    }
}
