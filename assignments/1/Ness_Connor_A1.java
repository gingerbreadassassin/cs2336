/*
* Filename: Ness_Connor_A1.java
* Author: Connor Ness
* Date: September 4, 2017
*
* This program takes input from the user about Diana Nyad's swimming habits
*   for five years. It calculates and then outputs her average speed
*   for each year, and in total. It expects floating point input,
*   but handles integer input gracefully.
*
* A two-dimensional array is used to manage the data. The first
*   element in the array contains the year. As all elements are floats,
*   they will need to be converted before printing if needed.
*   The loops to collect and print the data simply iterate through
*   the array's elements.
*
* Note that output formatting may behave strangely if unrealistic
*   numbers are entered.
*/

import java.util.Scanner;

public class Ness_Connor_A1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // setup input
        float totMPH = 0; // total mph for average calculation
        float[][] swimData; // array of arrays
        swimData = new float[5][3]; // sets up dimensions of the array
        swimData[0][0] = 1974; // populate the array with their respective years
        swimData[1][0] = 1975;
        swimData[2][0] = 1978;
        swimData[3][0] = 1979;
        swimData[4][0] = 2013;

        // for each year, gather data from user
        for(int i = 0; i < 5; i++) {
            System.out.println("Enter the distance Diana Nyad Swam input " +
                    (int)swimData[i][0] + ": ");
            swimData[i][1] = input.nextFloat();
            System.out.println("How many hours did it take Nyad to swim the distance?");
            swimData[i][2] = input.nextFloat();
        }

        // print out the table header
        System.out.println("+----------------------------------------------------------+");
        System.out.println("| Year  | Distance (miles)  | Time (hours)  | Speed (mph)  |");
        System.out.println("+----------------------------------------------------------+");

        // for each year, print the data and newline while totalling the mph
        for(int i = 0; i < 5; i++) {
            // format the data to be readable:
            // %[index$][flags][width][.precision]conversion
            System.out.printf("%1$6d  | %2$10.2f miles  | %3$6.2f hours  | %4$.2f mph%n",
                    (int)swimData[i][0], swimData[i][1], swimData[i][2],
                    (swimData[i][1] / swimData[i][2]));
            totMPH += (swimData[i][1] / swimData[i][2]);
        }

        // finally, calculate and print Nyad's average speed
        System.out.printf("%nDiana Nyad's average speed is: %1$.2f miles/hour", (totMPH / 5.0));
    }
}
