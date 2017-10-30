import java.util.Scanner;

public class Ness_Connor_A3 {

    public static void main() {
        Book testbook = new Book("The Hobbit", 15.99, "J.R.R. Tolkein", 123456789);
        System.out.printf(testbook.toString());
    }
}

class CatalogItem {
    private String title;
    private double price;

    CatalogItem() {
        title = "default";
        price = 0.00;
    }

    public CatalogItem(String Title, double Price) {
        title = Title;
        price = Price;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
}

class Book extends CatalogItem {
    private String author;
    private int isbn;

    Book() {
        super();
        author = "default";
        isbn = 0;
    }

    public Book(String Title, double Price, String Author, int ISBN) {
        super(Title, Price);
        author = Author;
        isbn = ISBN;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + super.getTitle() + " | Author: " + author
                + " | Price: " + super.getPrice() + " | ISBN: " + isbn;
    }
}

class AudioBook extends Book {
    private double runningTime;

    AudioBook() {
        super();
        runningTime = 0.0;
    }

    public AudioBook(String Title, double Price, String Author, int ISBN,
                     double RunningTime) {
        super(Title, Price, Author, ISBN);
        runningTime = RunningTime;
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 0.1;
    }

    public double getRunningTime() {
        return runningTime;
    }

    @Override
    public String toString() {
        return super.toString() + " | RunningTime: " + runningTime;
    }
}

class DVD extends CatalogItem {
    String director;
    int year, dvdcode;

    DVD() {
        super();
        director = "default";
        year = dvdcode = 0;
    }

    public DVD(String Title, double Price, String Director, int Year,
               int DVDcode) {
        super(Title, Price);
        director = Director;
        year = Year;
        dvdcode = DVDcode;
    }

    public int getDvdcode() {
        return dvdcode;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Title: " + super.getTitle() + " | Director: " + director
                + " | Price: " + super.getPrice() + " | Year: " + year +
                " | DVDCode: " + dvdcode;
    }
}