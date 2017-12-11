/*
Filename:   DVD.java
Author:     Connor Ness
Date:       December 10, 2017
 */

class DVD extends CatalogItem {
    private String director;
    private int year, dvdcode;

    public DVD(String Title, double Price, String Director, int Year,
               int DVDcode) {
        super(Title, Price, 0.8);
        director = Director;
        year = Year;
        dvdcode = DVDcode;
    }

    public DVD(DVD n) {
        super(n.getTitle(), n.getPrice()*0.8, 0.8);
        director = n.getDirector();
        year = n.getYear();
        dvdcode = n.getDvdcode();
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
        return String.format(
                "Title: %20s | Director: %18s | " +
                        "Price: %8s | Year: %4d | DVDCode: %12d"
                ,super.getTitle(), director, "$"+ df.format(getPrice()),
                year, dvdcode);
    }
}