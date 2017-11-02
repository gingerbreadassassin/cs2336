import java.util.Scanner;
import java.util.ArrayList;

public class Ness_Connor_A3 {
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

    private static void newBook() {
        System.out.print("Please enter the title of the book: ");
        String title = getLine();
        double price = getDoubleInput("Please enter the price of" +
                " the book: ");
        System.out.print("Please enter the Author of the book: ");
        String author = getLine();
        int isbn = getIntInput("Please enter the ISBN of the book: ");
        boolean exists = false;
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getIsbn() == isbn) {
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

    private static void newAudioBook() {
        String title = getLine();
        double price = getDoubleInput("Please enter the price of" +
                " the book: ");
        String author = getLine();
        int isbn = getIntInput("Please enter the ISBN of the book: ");
        double runtime = getDoubleInput("Please enter the runtime of" +
                " the book: ");
        boolean exists = false;
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getIsbn() == isbn) {
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

    private static void newDVD() {
        String title = getLine();
        double price = getDoubleInput("Please enter the price of" +
                " the DVD: ");
        String director = getLine();
        int year = getIntInput("Please enter the year of the DVD: ");
        int dvdcode = getIntInput("Please enter the DVDCode of the DVD: ");
        boolean exists = false;
        for(int i = 0; i < dvds.size(); i++) {
            if(dvds.get(i).getDvdcode() == dvdcode) {
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

    private static void dispCat() {
        for(int i = 0; i < books.size(); i++){
            System.out.println(books.get(i).toString());
        }
        System.out.println("-----------------------------------------------" +
                "----------------------------------------------------------" +
                "--------");
        for(int i = 0; i < dvds.size(); i++){
            System.out.println(dvds.get(i).toString());
        }
    }

    private static String getLine() {
        String text;
        Scanner in = new Scanner(System.in);
        text = in.nextLine();
        return text;
    }

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
