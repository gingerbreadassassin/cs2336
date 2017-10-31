import java.util.Scanner;

public class Ness_Connor_A3 {

    public static void main(String[] args) {
        Book testbook = new Book("The Hobbit", 15.99, "J.R.R. Tolkein", 123456789);
        System.out.println(testbook.toString());
        AudioBook testaudio = new AudioBook(testbook, 120.0);
        System.out.println(testaudio.toString());
        DVD testdvd = new DVD("FotR", 24.99, "Peter Jackson", 2001, 123456789);
        System.out.println(testdvd.toString());
    }
}