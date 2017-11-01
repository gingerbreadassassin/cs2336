import java.util.Scanner;
import java.util.ArrayList;

public class Ness_Connor_A3 {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<DVD> dvds = new ArrayList<>();

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {menu();}

    private static void menu() {

        System.out.printf(
                "%n**Welcome to the Comets Books and DVDs Store (Catalog Section)**%n" +
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
        int choice;

        // Make sure the user's input is an integer
        while(!input.hasNextInt()){
            System.out.println("Please use an integer.");
            input.next();
        }

        choice = input.nextInt();
        input.nextLine();

        switch(choice) {
            case 1: newBook();
                menu();
                break;
            case 2: newAudioBook();
                menu();
                break;
            // Add the user's desired book/dvd to their cart
            case 3: newDVD();
                menu();
                break;
            case 4: // remove book
                menu();
                break;
            // Display the user's cart
            case 5: // remove dvd
                menu();
                break;
            // Display the total and clear the user's cart
            case 6: // display catalog
                for(int i = 0; i < books.size(); i++){
                    System.out.println(books.get(i).toString());
                }
                for(int i = 0; i < dvds.size(); i++){
                    System.out.println(dvds.get(i).toString());
                }
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

    private static void newBook() {
        // String title = getLine("Please enter the title of the book: ");
        System.out.print("Please enter the title of the book: ");
        String title = input.nextLine();
        double price = getFloatInput("Please enter the price of the book: ");
        // String author = getLine("Please enter the Author of the book: ");
        System.out.print("Please enter the Author of the book: ");
        String author = input.nextLine();
        int isbn = getIntInput("Please enter the ISBN of the book: ");
        books.add(new Book(title, price, author, isbn));
    }

    private static void newAudioBook() {
        String title = getLine("Please enter the title of the book: ");
        double price = getFloatInput("Please enter the price of the book: ");
        String author = getLine("Please enter the Author of the book: ");
        int isbn = getIntInput("Please enter the ISBN of the book: ");
        double runtime = getFloatInput("Please enter the runtime of the book: ");
        books.add(new AudioBook(title, price, author, isbn, runtime));
    }

    private static void newDVD() {
        String title = getLine("Please enter the title of the DVD: ");
        double price = getFloatInput("Please enter the price of the DVD: ");
        String director = getLine("Please enter the Director of the DVD: ");
        int year = getIntInput("Please enter the year of the DVD: ");
        int dvdcode = getIntInput("Please enter the DVDCode of the DVD: ");
        dvds.add(new DVD(title, price, director, year, dvdcode));
    }

    private static String getLine(String msg) {
        String text;
        //input.next();
        System.out.println();
        do {
            System.out.print(msg);
            text = input.nextLine();
        } while(!input.hasNextLine());
        System.out.println();
        return text;
    }

    private static int getIntInput(String msg) {
        int number;
        input.next();
        System.out.println();
        do {
            System.out.print(msg);
            while (!input.hasNextInt()) {
                System.out.print("Please input an integer greater than 0: ");
                input.next();
                System.out.println();
            }
            number = input.nextInt();
        } while (number < 1);
        System.out.println();
        return number;
    }

    private static float getFloatInput(String msg) {
        float number;
        input.next();
        System.out.println();
        do {
            System.out.print(msg);
            while (!input.hasNextFloat()) {
                System.out.print("Please input a number greater than 0: ");
                input.next();
                System.out.println();
            }
            number = input.nextFloat();
        } while (number <= 0);
        System.out.println();
        return number;
    }
}
