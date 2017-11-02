/*
Filename:   Ness_Connor_A3.java
Author:     Connor Ness
Date:       November 1, 2017

This program simulates the manager's view of the online store explored in the
    previous assignment. It demonstrates the use of different classes, and
    exhibits inheritance and polymorphism.

Two ArrayLists are used to contain three types of objects. Because AudioBooks
    are child classes of Books, they qualify as that type, and may be contained
    in the same list.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Ness_Connor_A3 {
    // Using included ArrayList as directed by instructions
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<DVD> dvds = new ArrayList<>();

    public static void main(String[] args) {menu();}

    private static void menu() {

        System.out.printf(
                "%n**Welcome to the Comets Books and DVDs Store " +
                        "(Catalog Section)**%n" +
                        "%n" +
                        "Choose from the following options:%n" +
                        "1 - Add Book%n" +
                        "2 - Add AudioBook%n" +
                        "3 - Add DVD%n" +
                        "4 - Remove Book%n" +
                        "5 - Remove DVD%n" +
                        "6 - Display Catalog%n" +
                        "9 - Exit store%n"
        );

        // Get the user's input
        int choice = getIntInput("");

        switch(choice) {
            case 1: newBook();
                menu();
                break;
            case 2: newAudioBook();
                menu();
                break;
            case 3: newDVD();
                menu();
                break;
            case 4: removeBook();
                menu();
                break;
            case 5: removeDVD();
                menu();
                break;
            case 6: dispCat();
                menu();
                break;
            // Exit the program
            case 9: break;
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

//    newBook creates a new object of type "Book". It asks the user
//            to enter the parameters. It then checks to see if the ISBN
//            already exists. If it does, it tells the user and returns
//            to the main menu. If it does not, the item is added to the
//            books arraylist.
    private static void newBook() {
        System.out.println("Please enter the title of the book: ");
        String title = getStringInput();
        double price = getDoubleInput("Please enter the price of" +
                " the book: ");
        System.out.print("Please enter the Author of the book: ");
        String author = getStringInput();
        int isbn = getIntInput("Please enter the ISBN of the book: ");
        boolean exists = false;
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                exists = true;
            }
        }
        if(!exists) {
            books.add(new Book(title, price, author, isbn));
        }
        else {
            System.out.println("That item already exists!");
        }
    }

//    newAudioBook creates a new object of type "AudioBook". It asks the user
//            to enter the parameters. It then checks to see if the ISBN
//            already exists. If it does, it tells the user and returns
//            to the main menu. If it does not, the item is added to the
//            books arraylist.
    private static void newAudioBook() {
        String title = getStringInput();
        double price = getDoubleInput("Please enter the price of" +
                " the book: ");
        String author = getStringInput();
        int isbn = getIntInput("Please enter the ISBN of the book: ");
        double runtime = getDoubleInput("Please enter the runtime of" +
                " the book: ");
        boolean exists = false;
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                exists = true;
            }
        }
        if(!exists) {
            books.add(new AudioBook(title, price, author, isbn, runtime));
        }
        else {
            System.out.println("That item already exists!");
        }
    }

//    newDVD creates a new object of type "DVD". It asks the user
//            to enter the parameters. It then checks to see if the DVDCode
//            already exists. If it does, it tells the user and returns
//            to the main menu. If it does not, the item is added to the
//            dvds arraylist.
    private static void newDVD() {
        String title = getStringInput();
        double price = getDoubleInput("Please enter the price of" +
                " the DVD: ");
        String director = getStringInput();
        int year = getIntInput("Please enter the year of the DVD: ");
        int dvdcode = getIntInput("Please enter the DVDCode of the DVD: ");
        boolean exists = false;
        for (DVD dvd : dvds) {
            if (dvd.getDvdcode() == dvdcode) {
                exists = true;
            }
        }
        if(!exists) {
            dvds.add(new DVD(title, price, director, year, dvdcode));
        }
        else {
            System.out.println("That item already exists!");
        }
    }

//    removeBook is used to remove objects of type Book or AudioBook from
//            the books arraylist. It checks to see if the ISBN exists. If
//            it does not, it notifies the user that the item doesn't exist.
//            If it does, it removes the item and displays the catalog.
    private static void removeBook() {
        int isbn = getIntInput("Enter the ISBN of the item" +
                " to be removed: ");
        int index = -1;
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getIsbn() == isbn) {
                index = i;
            }
        }
        if(index == -1) {
            System.out.println("That item does not exist!");
        }
        else {
            books.remove(index);
            dispCat();
        }
    }

//    removeDVD is used to remove objects of type DVD from
//            the dvds arraylist. It checks to see if the DVDCode exists. If
//            it does not, it notifies the user that the item doesn't exist.
//            If it does, it removes the item and displays the catalog.
    private static void removeDVD() {
        int dvdcode = getIntInput("Enter the DVDCode of the item" +
                " to be removed: ");
        int index = -1;
        for(int i = 0; i < dvds.size(); i++) {
            if(dvds.get(i).getDvdcode() == dvdcode) {
                index = i;
            }
        }
        if(index == -1) {
            System.out.println("That item does not exist!");
        }
        else {
            dvds.remove(index);
            dispCat();
        }
    }

//    dispCat simply displays the catalog. It iterates through the books
//            arraylist, calling toString on each item. It prints a separator,
//            then prints the contents of the dvds arraylist
    private static void dispCat() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
        System.out.println("-----------------------------------------------" +
                "----------------------------------------------------------" +
                "--------");
        for (DVD dvd : dvds) {
            System.out.println(dvd.toString());
        }
    }

//    getStringInput gets input from the console. It makes sure that the
//            input is not empty, then returns the string.
    private static String getStringInput() {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        if(text.isEmpty()) {
            System.out.println("Please enter non-empty input: ");
            return getStringInput();
        }
        return text;
    }

//    getIntInput uses the nextLine and parses into an int, and makes sure
//            the input is positive.
    private static int getIntInput(String msg) {
        int number;
        Scanner in = new Scanner(System.in);
        try {
            number = Integer.parseInt(in.nextLine());
        }
        catch (NumberFormatException e) {
            System.out.println(msg);
            return getIntInput(msg);
        }
        return number;
    }

//    getDoubleInput does the same as getIntInput, but for doubles
    private static double getDoubleInput(String msg) {
        double number;
        Scanner in = new Scanner(System.in);
        try {
            number = Double.parseDouble(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(msg);
            return getDoubleInput(msg);
        }
        return number;
    }
}
