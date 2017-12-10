import java.text.DecimalFormat;

class Book extends CatalogItem {
    // This DecimalFormat object makes displaying doubles as dollars convenient.
    private static DecimalFormat df = new DecimalFormat("#.00");
    private String author;
    private int isbn;

    public Book(String Title, double Price, String Author, int ISBN) {
        super(Title, Price, 0.9);
        author = Author;
        isbn = ISBN;
    }

    protected Book(String Title, double Price, String Author, int ISBN,
                   double Discount) {
        super(Title, Price, Discount);
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