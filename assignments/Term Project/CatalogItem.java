/*
Filename:   CatalogItem.java
Author:     Connor Ness
Date:       December 10, 2017
 */

import java.text.DecimalFormat;

public abstract class CatalogItem implements Comparable<CatalogItem>{
    protected static DecimalFormat df = new DecimalFormat("#.00");
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

    public void setPrice(double p) {price = p;}

    // CatalogItem implements the Comparable.compareTo method so that
    //  two CatalogItem objects can be compared base on price.
    @Override
    public int compareTo(CatalogItem o) {

        double diff = price - o.getPrice();
        if(diff >= 0) {
            return 1;
        }
        return -1;
    }
}