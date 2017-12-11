/*
Filename:   AudioBook.java
Author:     Connor Ness
Date:       December 10, 2017
 */

public class  AudioBook extends Book {
    private double runningTime;

    public AudioBook(String Title, double Price, String Author, int ISBN,
                     double RunningTime) {
        super(Title, Price, Author, ISBN, 0.5);
        runningTime = RunningTime;
    }

    public AudioBook(AudioBook n) {
        super(n);
        this.runningTime = n.getRunningTime();
    }

    public double getRunningTime() {
        return runningTime;
    }

    @Override
    public String toString() {
        return String.format(
                "Title: %20s | Author: %15s | Price: %8s" +
                        " | ISBN: %10d | RunningTime: %7.2f "
                ,super.getTitle(), super.getAuthor(),
                "$" + df.format(getPrice()), super.getIsbn(), runningTime);
    }
}
