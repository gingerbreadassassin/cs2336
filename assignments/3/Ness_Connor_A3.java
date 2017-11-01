import java.util.Scanner;

public class Ness_Connor_A3 {
    private static Book[] books;
    private static DVD[] dvds;

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

        switch(choice) {
            case 1: addBook();
                menu();
                break;
            case 2: addAudioBook();
                menu();
                break;
            // Add the user's desired book/dvd to their cart
            case 3: addDVD();
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
                for(int i = 0; i <= books.length; i++){
                    System.out.println(books[i].toString());
                }
                for(int i = 0; i <= dvds.length; i++){
                    System.out.println(dvds[i].toString());
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

    private static void addBook() {
        System.out.println("Please enter the title of the book:");
        String title = input.nextLine();
        System.out.println("Please enter the price of the book:");
        double price = getFloatInput();
        System.out.println("Please enter the Author of the book:");
        String author = input.nextLine();
        System.out.println("Please enter the ISBN of the book:");
        int isbn = getIntInput();
        insertBook(new Book(title, price, author, isbn));
    }

    private static void addAudioBook() {
        System.out.println("Please enter the title of the book:");
        String title = input.nextLine();
        System.out.println("Please enter the price of the book:");
        double price = getFloatInput();
        System.out.println("Please enter the Author of the book:");
        String author = input.nextLine();
        System.out.println("Please enter the ISBN of the book:");
        int isbn = getIntInput();
        System.out.println("Please enter the runtime of the book:");
        double runtime = getFloatInput();
        insertBook(new AudioBook(title, price, author, isbn, runtime));
    }

    private static void addDVD() {
        System.out.println("Please enter the title of the DVD:");
        String title = input.nextLine();
        System.out.println("Please enter the price of the DVD:");
        double price = getFloatInput();
        System.out.println("Please enter the Director of the DVD:");
        String director = input.nextLine();
        System.out.println("Please enter the year of the DVD:");
        int year = getIntInput();
        System.out.println("Please enter the DVDCode of the DVD:");
        int dvdcode = getIntInput();
        insertDVD(new DVD(title, price, director, year, dvdcode));
    }

    private static void insertBook(Book book) {
        Book[] newbooks = new Book[books.length + 1];
        int i = 0;
        while(book.getIsbn() > books[i].getIsbn()) {
            i++;
        }
        System.arraycopy(books, 0, newbooks, 0, i - 1);
        System.arraycopy(books, i + 1, newbooks, i + 1, newbooks.length - i);
        newbooks[i] = book;
        books = newbooks;
    }

    private static void insertDVD(DVD dvd) {
        DVD[] newdvds = new DVD[dvds.length + 1];
        int i = 0;
        while(dvd.getDvdcode() > dvds[i].getDvdcode()) {
            i++;
        }
        System.arraycopy(dvds, 0, newdvds, 0, i - 1);
        System.arraycopy(dvds, i + 1, newdvds, i + 1, newdvds.length - i);
        newdvds[i] = dvd;
        dvds = newdvds;
    }

    private static int getIntInput() {
        int number;
        do {
            System.out.println("Please input an integer greater than 0:");
            while (!input.hasNextInt()) {
                System.out.println("Please input an integer greater than 0:");
            }
            number = input.nextInt();
        } while (number < 1);
        return number;
    }

    private static float getFloatInput() {
        float number;
        do {
            System.out.println("Please input a number greater than 0:");
            while (!input.hasNextFloat()) {
                System.out.println("Please input a number greater than 0:");
            }
            number = input.nextFloat();
        } while (number <= 0);
        return number;
    }
}
