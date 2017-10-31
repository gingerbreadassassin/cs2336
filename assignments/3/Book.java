class Book extends CatalogItem {
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
                + " | Price: " + super.getPrice() + " | ISBN: " + isbn;
    }
}