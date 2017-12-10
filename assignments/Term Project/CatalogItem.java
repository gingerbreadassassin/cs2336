public abstract class CatalogItem implements Comparable<CatalogItem>{
    private String title;
    private double price;
    private double discount;

    public CatalogItem(String Title, double Price, double Discount) {
        title = Title;
        price = Price;
        discount = Discount;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {return discount;}

    public String getTitle() {
        return title;
    }

    public String toString(){return null;}

    @Override
    public int compareTo(CatalogItem o) {

        double diff = price - o.getPrice();
        if(diff >= 0) {
            return 1;
        }
        return -1;
    }
}