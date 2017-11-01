public class  AudioBook extends Book {
    private double runningTime;

    public AudioBook() {
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
        return "Title: " + super.getTitle() + " | Author: " + super.getAuthor()
                + " | Price: " + (super.getPrice()*0.9) + " | ISBN: " +
                super.getIsbn();
    }
}
