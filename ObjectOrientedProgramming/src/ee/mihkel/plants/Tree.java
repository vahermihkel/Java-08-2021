package ee.mihkel.plants;

public class Tree extends Plant {
    private boolean isVili;

    public Tree(int price, boolean isSold, boolean isVili) {
        super(price, isSold);
        this.isVili = isVili;
    }
}
