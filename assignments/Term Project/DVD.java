import java.text.DecimalFormat;

class DVD extends CatalogItem {
    // This DecimalFormat object makes displaying doubles as dollars convenient.
    private static DecimalFormat df = new DecimalFormat("#.00");
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
        return "Title: " + super.getTitle() + " | Director: " + director
                + " | Price: $" + df.format(super.getPrice()) + " | Year: " +
                year + " | DVDCode: " + dvdcode;
    }
}