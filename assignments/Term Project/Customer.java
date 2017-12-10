import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("Duplicates")
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
            //  Pass the correct arrays and strings to modify the text
            //  displayed to reflect the correct type.
            case 1: displayArrays(books);
                menu();
                break;
            case 2: displayArrays(dvds);
                menu();
                break;
            // Add the user's desired book/dvd to their cart
            case 3: getInventoryNumber(books);
                menu();
                break;
            case 4: getInventoryNumber(dvds);
                menu();
                break;
            // Display the user's cart
            case 5: displayArrays(cart);
                menu();
                break;
            // Display the total and clear the user's cart
            case 6: checkout();
                cart.clear();
                menu();
                break;
            // Clear the user's cart
            case 7: cart.clear();
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

    private void getInventoryNumber(ArrayList list){}

    // The checkout method simulates checking out by displaying the total of the
    //  user's cart. It calls the getTotal method to get a string representation
    //  of the total plus tax.
    private void checkout() {
        System.out.printf(
                "Total + Tax %12s%n", getTotal(cart)
        );
    }

    // The getTotal method takes an array of doubles and sums the contents. This
    //  sum has tax applied and is then converted to a string representation
    //  with a dollar sign and two decimal places before returning this string.
    private static String getTotal(ArrayList<CatalogItem> items) {
        double dTotal = 0.0;
        for (CatalogItem item : items) {
            dTotal += item.getPrice();
        }

        dTotal += dTotal*0.0825;
        return "$" + df.format(dTotal);
    }
}
