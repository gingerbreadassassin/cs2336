import java.util.ArrayList;
@SuppressWarnings("Duplicates")
public class Ness_Connor_TP {


    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<DVD> dvds = new ArrayList<>();
    private static Validator input = new Validator();

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
    }

}
