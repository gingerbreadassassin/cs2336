/*
Filename:   Book.java
Author:     Connor Ness
Date:       November 1, 2017
 */
import java.text.DecimalFormat;

class Book extends CatalogItem {
    // This DecimalFormat object makes displaying doubles as dollars convenient.
    private static DecimalFormat df = new DecimalFormat("#.00");
    private String author;
    private int isbn;

    public Book() {
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
                + " | Price: $" + df.format(super.getPrice()) + " | ISBN: " +
                isbn;
    }
}