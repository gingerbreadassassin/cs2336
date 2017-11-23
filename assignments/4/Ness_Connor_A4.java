import java.util.Scanner;

public class Ness_Connor_A4 {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please input a string of characters: ");
        String chars = getStringInput();
    }



//    getStringInput gets input from the console. It makes sure that the
//            input is not empty, then returns the string.
    private static String getStringInput() {
        String text = input.nextLine();
        if(text.isEmpty()) {
            System.out.println("Please enter non-empty input: ");
            text = getStringInput();
        }
        return text.toLowerCase();
    }
}
