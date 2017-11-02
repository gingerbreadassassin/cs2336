/*
Filename:   Ness_Connor_A2.java
Author:     Connor Ness
Date:       September 24, 2017

This program simulates an online store selling textbooks and movies. It
    demonstrates mainly array manipulation, but also printing text in a clean,
    formatted manner and overloaded methods.

Six arrays are needed to accomplish this. The first four hold the names of the
    products and their corresponding prices. The last two represent the names
    and prices of items in the user's cart. Three arrays are strings, while
    the other three are doubles. These six arrays are private members of the
    project's class, and may be accessed by any method in the class.
*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ness_Connor_A2 {

    // These two arrays represent books and their prices
    private static String[] books = {"Intro to Java", "Intro to C++", "Python",
            "Perl", "C#"};
    private static double[] booksprices = {45.99, 89.34, 100.00, 25.00, 49.99};

    // These two arrays represent DVDs and their prices
    private static String[] dvds = {"Snow White", "Cinderella", "Dumbo",
            "Bambi", "Frozen"};
    private static double[] dvdsPrices = {19.99, 24.99, 17.99, 21.99, 24.99};

    // These two arrays represent the user's cart. They are initialized
    //  to zero elements, but are later modified by the addToCart
    //  and clearArrays methods.
    private static String[] cartItems = {};
    private static double[] cartPrices = {};

    // This DecimalFormat object makes displaying doubles as dollars convenient.
    private static DecimalFormat df = new DecimalFormat("#.00");

    // The main method does nothing but call the menu method
    public static void main(String[] args){
        menu();
    }

    // The menu method displays the main menu and prompts for the user's choice.
    //  It uses a switch operation based on the input. Each case calls its
    //  respective method, but also calls the menu method recursively, until
    //  the user chooses the "Exit" option. Each case also uses "break",
    //  which prevents the switch from continuing to the next option.
    private static void menu() {

        Scanner input = new Scanner(System.in); // Setup input
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

        // Get the user's input
        int choice;

        // Make sure the user's input is an integer
        while(!input.hasNextInt()){
            System.out.println("Please use an integer.");
            input.next();
        }

        choice = input.nextInt();

        switch(choice) {
            // Display the store's inventory of books and dvds, respectively.
            //  Pass the correct arrays and strings to modify the text
            //  displayed to reflect the correct type.
            case 1: displayArrays(books, booksprices, "Books");
                menu();
                break;
            case 2: displayArrays(dvds, dvdsPrices, "DVDs");
                menu();
                break;
            // Add the user's desired book/dvd to their cart
            case 3: getInventoryNumber(books, booksprices, "book");
                menu();
                break;
            case 4: getInventoryNumber(dvds, dvdsPrices, "dvd");
                menu();
                break;
            // Display the user's cart
            case 5: displayArrays(cartItems, cartPrices);
                menu();
                break;
            // Display the total and clear the user's cart
            case 6: checkout();
                clearArrays();
                menu();
                break;
            // Clear the user's cart
            case 7: clearArrays();
                menu();
                break;
            // Exit the program
            case 8: break;
            // In case the user enters an invalid input, a message stating as
            //  much is displayed, and returns to the menu.
            default:
                System.out.println(
                        "This option is not acceptable."
                );
                menu();
                break;
        }
    }

    // This displayArrays method displays the store's inventory of books or DVDs
    //  sorted by price from low to high. It creates an array of integers to
    //  represent the inventory number. It also creates temporary arrays
    //  matching the books/dvds/prices arrays to avoid sorting the original
    //  arrays. These temporary arrays are the arrays which are modified by
    //  the sorting algorithm and ultimately displayed. Note that the sorting
    //  algorithm analyzes the tempPrices array, but performs the swapping
    //  operations on all three arrays. Since this is the only time the arrays
    //  will be sorted, I chose not to create a separate sorting method.
    private static void displayArrays(String[] itemsArray, double[] pricesArray,
                                      String itemType) {

        // Create temporary arrays to avoid modifying original arrays
        String[] tempItems = new String[itemsArray.length];
        double[] tempPrices = new double[pricesArray.length];

        // Display the table heading. The middle value will change depending
        //  on what's being displayed (Books vs DVDs) while maintaining padding.
        System.out.printf(
                "Inventory Number    %1$5s                  Prices%n" +
                "-------------------------------------------------%n",
        itemType);

        // Create an array of integers to hold the inventory number of each item
        int[] invNum = new int[tempItems.length];

        // Populate the inventory number array and copy each element of the
        //  books/dvds arrays into the temporary arrays
        for(int i = 0; i < invNum.length; i++) {
            invNum[i] = i + 1;
            tempItems[i] = itemsArray[i];
            tempPrices[i] = pricesArray[i];
        }

        // Sort arrays by price, low to high using selection sort

        // minIndex is the index of the smallest value. MinInvNum, minTitle,
        //  and minValue are the values of the items with the lowest price.
        int minIndex, minInvNum;
        String minTitle;
        double minValue;

        // scan is the index of the item currently being analyzed. It increments
        //  by one each iteration, so the first element is analyzed only once.
        for (int scan = 0; scan < (tempItems.length - 1); scan++) {
            // Set all values to the item currently being analyzed. If it
            //  happens to be the smallest, it is already in the correct place
            //  and no swaps will be made.
            minIndex = scan;
            minInvNum = invNum[scan];
            minTitle = tempItems[scan];
            minValue = tempPrices[scan];

            // Compare the current item's price to each subsequent item. If
            //  the current item is larger than the next, set the cheaper of the
            //  two to the item being analyzed.
            for (int i = scan + 1; i < invNum.length; i++) {
                if (tempPrices[i] < minValue) {
                    minInvNum = invNum[i];
                    minTitle = tempItems[i];
                    minValue = tempPrices[i];
                    minIndex = i;
                }
            }

            // Set the element in each array corresponding to the cheapest item
            //  to whatever element of the array we began scanning.
            invNum[minIndex] = invNum[scan];
            tempItems[minIndex] = tempItems[scan];
            tempPrices[minIndex] = tempPrices[scan];

            // Set the element in each array we began scanning at to the value
            //  of the cheapest item.
            invNum[scan] = minInvNum;
            tempItems[scan] = minTitle;
            tempPrices[scan] = minValue;
        }

        // Display each element of the arrays in a tabular format.
        for (int x = 0; x < tempItems.length; x++) {
            String price = "$" + df.format(tempPrices[x]);
            System.out.printf("%-20d%-16s%13s%n", invNum[x], tempItems[x],
                    price);
        }
        System.out.println();
    }

    // This displayArrays method is an overloaded method which displays the
    //  user's cart. As no sorting is needed and the cart is product-type
    //  agnostic, it only takes two array arguments. It calls the getTotal
    //  method to get the total price, plus tax, of the contents of the cart.
    private static void displayArrays(String[] items, double[] prices) {

        // If the user's cart is empty, tell them so.
        if(items.length == 0) {
            System.out.println("Your cart is empty.");
        }

        // Otherwise, display the cart's contents inp a neat tabular format.
        else {

            // Print the header
            System.out.println("Items             Prices");
            System.out.println("------------------------");

            // Print each item in the cart
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

    // The getInventoryNumber method takes two arrays and a string representing
    //  the type of items the user wishes to add to their cart. It only accepts
    //  input within the range of the available inventory, or the special
    //  escape case (-1). It then calls the addToCart method to add the chosen
    //  item, if any, to the user's cart.
    private static void getInventoryNumber(String[] items,
                                           double[] prices, String item) {

        Scanner input = new Scanner(System.in); // setup input
        int choice;

        do {
            // The prompt is aware of the type of item the user wishes to add
            System.out.println(
                    "Please enter the inventory number of the " + item +
                            " to add to cart."
            );
            System.out.println("Enter -1 to return to the main menu.");

            // Make sure user's input is an integer
            while(!input.hasNextInt()){
                System.out.println("Please use an integer.");
                input.next();
            }

            choice = input.nextInt();

        } while(choice != -1 && ((choice > items.length + 1) || choice < 1));

        // Convert user's input to zero-index
        --choice;

        // If the user did not choose to return to the menu, add the item to the
        //  the cart.
        if(0 <= choice && choice <= items.length) {
            addToCart(items[choice], prices[choice]);
        }
    }

    // The addToCart method takes two arguments, a string and a double, which
    //  represent the title and price of the item. As the cart may be of
    //  variable length, temporary arrays are created which are 1 element longer
    //  than the current cart arrays. The contents of the current arrays are
    //  then copied into the temporary arrays, the new item placed in the last
    //  element, and finally the current arrays are reassigned to the temporary
    //  arrays.
    private static void addToCart(String itemName, double itemPrice) {

        // Create temporary arrays equal to one plus the size of the current
        //  cart arrays.
        String[] tempCartItems = new String[cartItems.length + 1];
        double[] tempCartPrices = new double[cartItems.length + 1];

        // Instantiate an index variable outside the for loop so it may be
        //  accessed later.
        int i;

        // Set the contents of the temporary arrays equal to those of the
        //  current cart arrays, leaving the last element empty.
        for(i = 0; i < cartItems.length; i++) {
            tempCartItems[i] = cartItems[i];
            tempCartPrices[i] = cartPrices[i];
        }

        // Set the last element of the temporary arrays equal to the item being
        //  added to the cart
        tempCartItems[i] = itemName;
        tempCartPrices[i] = itemPrice;

        // Finally, reassign the cart arrays' names to the temporary array
        //  objects. Java's garbage collection will handle the old arrays.
        cartItems = tempCartItems;
        cartPrices = tempCartPrices;
    }

    // The checkout method simulates checking out by displaying the total of the
    //  user's cart. It calls the getTotal method to get a string representation
    //  of the total plus tax.
    private static void checkout() {
        System.out.printf(
                "Total + Tax %12s%n", getTotal(cartPrices)
        );
    }

    // The clearArrays method deletes the contents of the user's cart by
    //  setting the cart arrays to new arrays with zero elements.
    private static void clearArrays() {
        cartItems = new String[0];
        cartPrices = new double[0];
    }

    // The getTotal method takes an array of doubles and sums the contents. This
    //  sum has tax applied and is then converted to a string representation
    //  with a dollar sign and two decimal places before returning this string.
    private static String getTotal(double[] prices) {
        double dTotal = 0.0;
        for (double price : prices) {
            dTotal += price;
        }

        dTotal += dTotal*0.0825;
        return "$" + df.format(dTotal);
    }
}
