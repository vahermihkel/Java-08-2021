package ee.mihkel.item;

import ee.mihkel.World;

import java.util.Random;

public abstract class Item {
    private int xCoord;
    private int yCoord;
    private char symbol;
    private int strength;
    private int durability;
    private String name;

    public Item(World world, int strength, String name) {
        this.xCoord = this.getRandomCoordinate(world.getWidth()-2);
        this.yCoord = this.getRandomCoordinate(world.getHeight()-2);
        this.symbol = 'I';
        this.strength = strength;
        this.name = name;
    }

    private int getRandomCoordinate(int maxCoord) {
        Random random = new Random();
        return random.nextInt(maxCoord)+1;
    }

    public void increaseDurability() {
        // this.durability = this.durability + 1;
        this.durability++;
    }

    public void decreaseDurability() {
        // this.durability = this.durability - 1;
        this.durability--;
    }

    // polymorphism
    public void regenerateDurability() {
        this.durability = 1;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getStrength() {
        return strength;
    }

    public int getDurability() {
        return durability;
    }

    public String getName() {
        return name;
    }
}
