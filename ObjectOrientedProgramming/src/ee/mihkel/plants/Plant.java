package ee.mihkel.plants;

import ee.mihkel.Sellable;

public abstract class Plant implements Sellable {
    private int price;
    private boolean isSold;

    public Plant(int price, boolean isSold) {
        this.price = price;
        this.isSold = isSold;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setAsSold() {
        this.isSold = true;
    }
}
