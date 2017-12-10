import java.util.ArrayList;
@SuppressWarnings("Duplicates")
public class Ness_Connor_TP {

    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<DVD> dvds = new ArrayList<>();
    private static Validator input = new Validator();
    private static CSV credentials = new CSV("credentials.txt");

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

        char choice = input.getStringInput().charAt(0);

        switch(choice) {
            case 'A':
                if(login()) {
                    manager.menu();
                }
                else {
                    System.out.println("Unrecognized Credentials");
                }
                menu();
                break;
            case 'B':
                customer.menu();
                menu();
                break;
            case 'C':
                break;
            default:
                System.out.println(
                        "This option is not acceptable."
                );
                menu();
                break;
        }
    }

    private static boolean login() {
        System.out.printf("Please enter your username: ");
        String uid = input.getStringInput();
        System.out.printf("Please enter your password: ");
        String pid = input.getStringInput();
        return credentials.contains(uid + "," + pid);
    }

}
