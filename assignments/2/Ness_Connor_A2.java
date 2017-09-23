/*
Filename:   Ness_Connor_A2.java
Author:     Connor Ness
Date:       September 24, 2017
*/

import java.util.Scanner;

public class Ness_Connor_A2 {
    public static void main(String[] args){

    }

    public static void menu() {

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
            case 1: // browse books
                menu();
            case 2: // browse DVDs
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
            case 8: return;
            default:
                System.out.println(
                        "Invalid input! Please use an integer from 1-8."
                );
                menu();
        }


    }
}
