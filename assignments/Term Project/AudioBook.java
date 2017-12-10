import java.text.DecimalFormat;

public class  AudioBook extends Book {
    // This DecimalFormat object makes displaying doubles as dollars convenient.
    private static DecimalFormat df = new DecimalFormat("#.00");
    private double runningTime;

    public AudioBook(String Title, double Price, String Author, int ISBN,
                     double RunningTime) {
        super(Title, Price, Author, ISBN, 0.5);
        runningTime = RunningTime;
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 0.9;
    }

    public double getRunningTime() {
        return runningTime;
    }

    @Override
    public String toString() {
        return "Title: " + super.getTitle() + " | Author: " + super.getAuthor()
                + " | Price: $" + df.format(super.getPrice()*0.9) +
                " | ISBN: " + super.getIsbn() +" | RunningTime: " + runningTime;
    }
}
