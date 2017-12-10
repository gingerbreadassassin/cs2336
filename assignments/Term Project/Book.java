class Book extends CatalogItem {
    // This DecimalFormat object makes displaying doubles as dollars convenient.

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
        return String.format(
                "Title: %20s | Author: %15s | Price: %8s | ISBN: %10d"
                , super.getTitle(), author, "$"+df.format(getPrice()), isbn);
    }
}