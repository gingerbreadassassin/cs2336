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

    private static DecimalFormat df = new DecimalFormat("#.00");

    private static String[] cartItems = {};
    private static double[] cartPrices = {};

    public static void main(String[] args){
        menu();
    }

    private static void menu() {

        Scanner input = new Scanner(System.in); // setup input
        System.out.printf(
                "%n**Welcome to the Comets Books and DVDs Store**%n" +
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

        int choice = input.nextInt();

        switch(choice) {
            case 1: displayArrays(books, booksprices, "Books");
                menu();
                break;
            case 2: displayArrays(dvds, dvdsPrices, "DVDs");
                menu();
                break;
            case 3: getInventoryNumber(books, booksprices, "book");
                menu();
                break;
            case 4: getInventoryNumber(dvds, dvdsPrices, "dvd");
                menu();
                break;
            case 5: displayArrays(cartItems, cartPrices);
                menu();
                break;
            case 6: checkout();
                clearArrays();
                menu();
                break;
            case 7: clearArrays();
                menu();
                break;
            case 8: break;
            default:
                System.out.println(
                        "Invalid input! Please use an integer from 1-8."
                );
                menu();
                break;
        }
    }

    private static void displayArrays(String[] itemsArray, double[] pricesArray,
                                      String itemType) {

        String[] tempItems = new String[itemsArray.length];
        double[] tempPrices = new double[pricesArray.length];

        // format the data to be readable:
        // %[index$][flags][width][.precision]conversion
        System.out.printf(
                "Inventory Number    %1$5s                  Prices%n" +
                "-------------------------------------------------%n",
        itemType);

        int[] invNum = new int[tempItems.length];
        for(int i = 0; i < invNum.length; i++) {
            invNum[i] = i + 1;
            tempItems[i] = itemsArray[i];
            tempPrices[i] = pricesArray[i];
        }

        // sort arrays by price, low to high using selection sort
        // TODO: more comments to describe swaps to three arrays
        int minIndex, minInvNum;
        String minTitle;
        double minValue;

        for (int scan = 0; scan < (tempItems.length - 1); scan++) {
            minIndex = scan;
            minInvNum = invNum[scan];
            minTitle = tempItems[scan];
            minValue = tempPrices[scan];

            for (int i = scan + 1; i < invNum.length; i++) {
                if (tempPrices[i] < minValue) {
                    minInvNum = invNum[i];
                    minTitle = tempItems[i];
                    minValue = tempPrices[i];
                    minIndex = i;
                }
            }

            invNum[minIndex] = invNum[scan];
            tempItems[minIndex] = tempItems[scan];
            tempPrices[minIndex] = tempPrices[scan];

            invNum[scan] = minInvNum;
            tempItems[scan] = minTitle;
            tempPrices[scan] = minValue;
        }

        for (int x = 0; x < tempItems.length; x++) {
            String price = "$" + df.format(tempPrices[x]);
            System.out.printf("%-20d%-16s%13s%n", invNum[x], tempItems[x],
                    price);
        }
        System.out.println();
    }

    private static void displayArrays(String[] items, double[] prices) {

        if(items.length == 0) {
            System.out.println("Your cart is empty.");
        }
        else {
            System.out.println("Items             Prices");
            System.out.println("------------------------");

            for (int x = 0; x < items.length; x++) {
                String price = "$" + df.format(prices[x]);
                System.out.printf("%-15s%9s%n", items[x],
                        price);
            }
            System.out.println("------------------------");
            System.out.printf(
                    "Total + Tax %12s%n", getTotal(prices)
            );
        }

    }

    private static void getInventoryNumber(String[] items,
                                           double[] prices, String item) {

        Scanner input = new Scanner(System.in); // setup input
        int choice;

        do {
            System.out.println(
                    "Please enter the inventory number of the " + item +
                            " to add to cart."
            );
            System.out.println("Enter -1 to return to the main menu.");
            choice = input.nextInt();

        } while(choice != -1 && ((choice > items.length + 1) || choice < 1));

        --choice;
        if(0 <= choice && choice <= items.length) {
            addToCart(items[choice], prices[choice]);
        }
    }

    private static void addToCart(String itemName, double itemPrice) {
        String[] tempCartItems = new String[cartItems.length + 1];
        double[] tempCartPrices = new double[cartItems.length + 1];

        int i;

        for(i = 0; i < cartItems.length; i++) {
            tempCartItems[i] = cartItems[i];
            tempCartPrices[i] = cartPrices[i];
        }

        tempCartItems[i] = itemName;
        tempCartPrices[i] = itemPrice;

        cartItems = tempCartItems;
        cartPrices = tempCartPrices;
    }

    private static void checkout() {
        System.out.printf(
                "Total + Tax %12s%n", getTotal(cartPrices)
        );
    }

    private static void clearArrays() {
        cartItems = new String[0];
        cartPrices = new double[0];
    }

    private static String getTotal(double[] prices) {
        double dTotal = 0.0;
        for (double price : prices) {
            dTotal += price;
        }

        dTotal += dTotal*0.0825;
        return "$" + df.format(dTotal);
    }
}
