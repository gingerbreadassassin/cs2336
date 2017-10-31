class DVD extends CatalogItem {
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
                + " | Price: " + super.getPrice() + " | Year: " + year +
                " | DVDCode: " + dvdcode;
    }
}