package ee.mihkel.plants;

public class Flower extends Plant {
    private Color color;

    public Flower(int price, boolean isSold, Color color) {
        super(price, isSold);
        this.color = color;
    }
}
