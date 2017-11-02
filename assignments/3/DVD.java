/*
Filename:   DVD.java
Author:     Connor Ness
Date:       November 1, 2017
 */

import java.text.DecimalFormat;

class DVD extends CatalogItem {
    // This DecimalFormat object makes displaying doubles as dollars convenient.
    private static DecimalFormat df = new DecimalFormat("#.00");
    private String director;
    private int year, dvdcode;

    public DVD() {
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
                + " | Price: $" + df.format(super.getPrice()) + " | Year: " +
                year + " | DVDCode: " + dvdcode;
    }
}