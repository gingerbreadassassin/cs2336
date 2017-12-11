/*
Filename:   Ness_Connor_TP.java
Author:     Connor Ness
Date:       December 10, 2017

Ness_Connor_TP unifies assigments 2 and 3 into a single application, simulating
 a bookstore. It has two modes: a management side and a customer-facing side.
 It instantiates the ArrayLists for Books and DVDs, so that these lists are
 accessible throughout the whole program. It also instantiates a Validator and
 FileOp objects. The Validator object is shared by all classes, while the FileOp
 object is used solely for authentication of a manager.
 */

import java.util.ArrayList;
public class Ness_Connor_TP {

    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<DVD> dvds = new ArrayList<>();
    private static Validator input = new Validator();
    private static FileOp credentials = new FileOp("credentials.txt");

    // the Management and customer UI's are distinct objects
    private static Manager manager = new Manager(input, books, dvds);
    private static Customer customer = new Customer(input, books, dvds);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {

        System.out.printf(
                "%n**Welcome to the Comets Books and DVDs Store**%n" +
                "%n" +
                "Please select your role:%n" +
                "A - store manager%n" +
                "B - customer%n" +
                "C - exit store%n"
        );

        // Make the user's life a little easier by autocapitalizing input
        String choice = input.getStringInput().toUpperCase();

        switch(choice) {
            case "A":
                if(login()) {
                    manager.menu();
                }
                else {
                    System.out.println("Unrecognized Credentials");
                }
                menu();
                break;
            case "B":
                customer.menu();
                menu();
                break;
            case "C":
                break;
            default:
                System.out.println(
                        "This option is not acceptable."
                );
                menu();
                break;
        }
    }

//  login asks the user for their username and password, concatenates them
//   with a comma, and searches the credentials file for a match
    private static boolean login() {
        System.out.printf("Please enter your username: ");
        String uid = input.getStringInput();
        System.out.printf("Please enter your password: ");
        String pid = input.getStringInput();
        return credentials.contains(uid + "," + pid);
    }

}
