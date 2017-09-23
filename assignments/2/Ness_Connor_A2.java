/*
Filename:   Ness_Connor_A2.java
Author:     Connor Ness
Date:       September 24, 2017
*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ness_Connor_A2 {

    private static String[] books = {"Intro to Java", "Intro to C++", "Python",
            "Perl", "C#"};
    private static double[] booksprices = {45.99, 89.34, 100.00, 25.00, 49.99};

    private static String[] dvds = {"Snow White", "Cinderella", "Dumbo",
            "Bambi", "Frozen"};
    private static double[] dvdsPrices = {19.99, 24.99, 17.99, 21.99, 24.99};

    // private String[] cartItems = {};

    public static void main(String[] args){
        menu();
    }

    private static void menu() {

        Scanner input = new Scanner(System.in); // setup input
        System.out.printf(
                "**Welcome to the Comets Books and DVDs Store**%n" +
                "%n" +
                "Choose from the following options:%n" +
                "1 - Browse books inventory (price low to high)%n" +
                "2 - Browse DVDs inventory (price low to high)%n" +
                "3 - Add a book to the cart%n" +
                "4 - Add a DVD to the cart%n" +
                "5 - View cart%n" +
                "6 - Checkout%n" +
                "7 - Cancel Order%n" +
                "8 - Exit store%n"
        );

        switch(input.nextInt()) {
            case 1: displayArrays(books, booksprices, "Books");
                menu();
            case 2: displayArrays(dvds, dvdsPrices, "DVDs");
                menu();
            case 3: // add book
                menu();
            case 4: // add DVD
                menu();
            case 5: // view kart
                menu();
            case 6: // checkout
                menu();
            case 7: // cancel order
                menu();
            case 8: break;
            default:
                System.out.println(
                        "Invalid input! Please use an integer from 1-8."
                );
                menu();
        }
    }

    private static void displayArrays(String[] itemsArray, double[] pricesArray,
                                      String itemType) {

        // format the data to be readable:
        // %[index$][flags][width][.precision]conversion
        System.out.printf(
                "Inventory Number    %1$5s                  Prices%n" +
                "-------------------------------------------------%n",
        itemType);

        int[] invNum = new int[itemsArray.length];
        for(int i = 0; i < invNum.length; i++) {
            invNum[i] = i + 1;
        }

        // sort arrays by price, low to high using selection sort
        // TODO: more comments to describe swaps to three arrays
        int minIndex, minInvNum;
        String minTitle;
        double minValue;

        for (int scan = 0; scan < (itemsArray.length - 1); scan++) {
            minIndex = scan;
            minInvNum = invNum[scan];
            minTitle = itemsArray[scan];
            minValue = pricesArray[scan];

            for (int i = scan + 1; i < invNum.length; i++) {
                if (pricesArray[i] < minValue) {
                    minInvNum = invNum[i];
                    minTitle = itemsArray[i];
                    minValue = pricesArray[i];
                    minIndex = i;
                }
            }

            invNum[minIndex] = invNum[scan];
            itemsArray[minIndex] = itemsArray[scan];
            pricesArray[minIndex] = pricesArray[scan];

            invNum[scan] = minInvNum;
            itemsArray[scan] = minTitle;
            pricesArray[scan] = minValue;
        }

        DecimalFormat df = new DecimalFormat("#.00");
        for (int x = 0; x < itemsArray.length; x++) {
            String price = "$" + df.format(pricesArray[x]);
            System.out.printf("%-20d%-16s%13s%n", invNum[x], itemsArray[x],
                    price);
        }
        System.out.println();
    }
}
