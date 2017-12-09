/*
Filename:   CatalogItem.java
Author:     Connor Ness
Date:       November 1, 2017
 */

public abstract class CatalogItem {
    private String title;
    private double price;

    public CatalogItem() {
        title = "default";
        price = 0.00;
    }

    public CatalogItem(String Title, double Price) {
        title = Title;
        price = Price;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
}