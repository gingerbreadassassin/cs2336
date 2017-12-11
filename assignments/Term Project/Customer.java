/*
Filename:   Customer.java
Author:     Connor Ness
Date:       December 10, 2017
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Customer {

    // This DecimalFormat object makes displaying doubles as dollars convenient.
    private static DecimalFormat df = new DecimalFormat("#.00");

    private Validator input;
    private ArrayList<Book> books;
    private ArrayList<DVD> dvds;
    private ArrayList<CatalogItem> cart;

    public Customer(Validator i, ArrayList<Book> b, ArrayList<DVD> d){
        input = i;
        books = b;
        dvds = d;
        cart = new ArrayList<>();
    }

    public void menu() {
        System.out.printf(
                "Choose from the following options:%n" +
                    "1 - Browse books inventory (price low to high)%n" +
                    "2 - Browse DVDs inventory (price low to high)%n" +
                    "3 - Add a book to the cart%n" +
                    "4 - Add a DVD to the cart%n" +
                    "5 - Delete a book from cart%n" +
                    "6 - Delete a DVD from cart%n" +
                    "7 - View cart%n" +
                    "8 - Checkout%n" +
                    "9 - Done Shopping%n"
        );

        int choice = input.getIntInput("");

        switch(choice) {
            // Display the store's inventory of books and dvds, respectively.
            case 1: displayArrays(books);
                menu();
                break;
            case 2: displayArrays(dvds);
                menu();
                break;
            // Add/remove the user's desired book/dvd to/from their cart
            case 3: addBookToCart();
                menu();
                break;
            case 4: addDVDToCart();
                menu();
                break;
            case 5: removeBook();
                menu();
                break;
            case 6: removeDVD();
                menu();
                break;
            // Show the user's cart
            case 7: displayArrays(cart);
                menu();
                break;
            case 8: checkout();
                cart.clear();
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


    private void displayArrays(ArrayList things){
        ArrayList<CatalogItem> items = new ArrayList<CatalogItem>(things);
        Collections.sort(items);
        for (Object item : items) {
            System.out.println(item.toString());
        }
    }

    private void removeBook() {
        int isbn = input.getIntInput("Please enter the ISBN of " +
                "the book you wish to remove from your cart: ");
        for(CatalogItem item : cart) {
            if(item instanceof Book) {
                if(((Book) item).getIsbn() == isbn) {
                    cart.remove(item);
                    return;
                }
            }
        }
        System.out.println("The book with ISBN: " + isbn + " was not found!");
    }

    private void removeDVD() {
        int dvdc = input.getIntInput("Please enter the DVDCode of " +
                "the DVD you wish to remove from your cart: ");
        for(CatalogItem item : cart) {
            if(item instanceof DVD) {
                if(((DVD) item).getDvdcode() == dvdc) {
                    cart.remove(item);
                    return;
                }
            }
        }
        System.out.println("The DVD with code: " + dvdc + " was not found!");
    }

    private void addBookToCart() {
        int isbn = input.getIntInput("Please enter the ISBN of " +
                "the book you wish to add to your cart: ");
        for(Book book : books) {
            if(book.getIsbn() == isbn) {
                if(book instanceof AudioBook) {
                    cart.add(new AudioBook(book.getTitle(),
                            book.getPrice()*book.getDiscount(),
                            book.getAuthor(), book.getIsbn(),
                            ((AudioBook) book).getRunningTime()));
                }
                else {
                    cart.add(new Book(book.getTitle(),
                        book.getPrice()*book.getDiscount(),
                        book.getAuthor(), book.getIsbn()));
                }
                return;
            }
        }
        System.out.println("The book with ISBN: " + isbn + " was not found!");
    }

    private void addDVDToCart() {
        int dvdc = input.getIntInput("Please enter the DVDCode of the" +
                " DVD you wish to add to your cart: ");
        for(DVD dvd : dvds) {
            if(dvd.getDvdcode() == dvdc) {
                cart.add(new DVD(dvd));
                return;
            }
        }
        System.out.println("The DVD with code: " + dvdc + " was not found!");
    }


    private void checkout() {
        System.out.printf(
                "Total + Tax %12s%n", getTotal(cart)
        );
    }


    private static String getTotal(ArrayList<CatalogItem> items) {
        double dTotal = 0.0;
        for (CatalogItem item : items) {
            dTotal += item.getPrice();
        }

        dTotal += dTotal*0.0825;
        return "$" + df.format(dTotal);
    }
}
