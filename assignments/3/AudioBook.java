/*
Filename:   AudioBook.java
Author:     Connor Ness
Date:       November 1, 2017
 */

import java.text.DecimalFormat;

public class  AudioBook extends Book {
    // This DecimalFormat object makes displaying doubles as dollars convenient.
    private static DecimalFormat df = new DecimalFormat("#.00");
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
