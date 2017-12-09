import java.util.Scanner;

public class Validator implements Acceptable {

    private static Scanner input = new Scanner(System.in);

    @Override
    public boolean isNonEmptyString(String s) {
        return !s.isEmpty();
    }

    @Override
    public boolean isPositiveInput(double d) {
        return d > 0;
    }

    //    getStringInput gets input from the console. It makes sure that the
    //            input is not empty, then returns the string.
    public static String getStringInput() {
        String text = input.nextLine();
        if(text.isEmpty()) {
            System.out.println("Please enter non-empty input: ");
            text = getStringInput();
        }
        return text;
    }

@SuppressWarnings("Duplicates")
    //    getIntInput uses the nextLine and parses into an int, and makes sure
    //            the input is positive.
    public static int getIntInput(String msg) {
        int number;
        System.out.println(msg);
        try {
            number = Integer.parseInt(input.nextLine());
        }
        catch (NumberFormatException e) {
            return getIntInput(msg);
        }
        if(number < 1) {
            System.out.println("Please enter an integer greater than 0!");
            return getIntInput(msg);
        }
        return number;
    }

@SuppressWarnings("Duplicates")
    //    getDoubleInput does the same as getIntInput, but for doubles
    public static double getDoubleInput(String msg) {
        double number;
        System.out.println(msg);
        try {
            number = Double.parseDouble(input.nextLine());
        } catch (NumberFormatException e) {
            return getDoubleInput(msg);
        }
        if(number < 1) {
            System.out.println("Please enter a number greater than 0!");
            return getDoubleInput(msg);
        }
        return number;
    }
}
