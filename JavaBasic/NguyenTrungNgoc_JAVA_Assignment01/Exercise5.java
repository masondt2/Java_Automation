package NguyenTrungNgoc_JAVA_Assignment01;

import java.util.Scanner;

/*
Write a Java program to takes the user for a distance (in meters) and the time was taken (as three numbers:
hours, minutes, seconds), and display the speed, in meters per second, kilometers per hour and miles per
hour (hint: 1 mile = 1609 meters).

Test Data
Input distance in meters: 2500
Input hour: 5
Input minutes: 56
Input seconds: 23
Expected Output :
Your speed in meters/second is 0.11691531
Your speed in km/h is 0.42089513
Your speed in miles/h is 0.26158804
 */
public class Exercise5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input distance in meters: ");
        double distanceInMeter = sc.nextDouble();
        System.out.print("Input hour: ");
        int hour = sc.nextInt();
        System.out.print("Input minutes: ");
        int min = sc.nextInt();
        System.out.print("Input seconds: ");
        int sec = sc.nextInt();

        //Total time in seconds
        int totalSeconds = hour*60*60 + min*60 + sec;

        //Calculate speed in meters/second:
        double speedMeterPerSecond = distanceInMeter / totalSeconds;

        //Calculate speed in km/h:
        double distanceInKilomet = distanceInMeter / 1000.0;
        double speedKilometPerHour = distanceInKilomet / (totalSeconds / 3600.0);

        //Calculate speed in Miles/h:
        double distanceInMiles = distanceInMeter / 1609.0;
        double speedMilesPerHour = distanceInMiles / (totalSeconds / 3600.0);

        System.out.printf("Your speed in meters/second is %.8f \n",speedMeterPerSecond);
        System.out.printf("Your speed in km/h is %.8f \n",speedKilometPerHour);
        System.out.printf("Your speed in miles/h is %.8f \n",speedMilesPerHour);
        sc.close();
    }
}
