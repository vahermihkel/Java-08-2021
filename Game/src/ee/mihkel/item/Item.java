package ee.mihkel.item;

import ee.mihkel.World;

import java.util.Random;

public abstract class Item {
    private final int xCoord;
    private final int yCoord;
    private final char symbol;
    private int strength;
    private int durability;
    private final String name;
    private ItemType itemType = ItemType.BRONZE;
    private int level;

    public Item(World world, int strength, String name, char symbol) {
        this.xCoord = this.getRandomCoordinate(world.getWidth()-2);
        this.yCoord = this.getRandomCoordinate(world.getHeight()-2);
        this.strength = strength;
        this.name = name;
        this.level = 0;
        this.symbol = symbol;
    }

    // Constructor Overloading
    public Item(World world, String name, char symbol) {
        this.xCoord = this.getRandomCoordinate(world.getWidth()-2);
        this.yCoord = this.getRandomCoordinate(world.getHeight()-2);
        this.name = name;
        this.symbol = symbol;
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
        this.level++;
        checkTypeByLevel();
    }

    private void checkTypeByLevel() {
        int adjustedLevel = level/3;
        switch (adjustedLevel) {
            case 0:
                this.itemType = ItemType.BRONZE;
                break;
            case 1:
                this.itemType = ItemType.SILVER;
                break;
            case 2:
                this.itemType = ItemType.GOLD;
                break;
            default:
                this.itemType = ItemType.PLATINUM;
                break;
        }
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
        switch (itemType) {
            case SILVER:
                return (int) (strength * 1.5);
            case GOLD:
                return (int) (strength * 2);
            case PLATINUM:
                return (int) (strength * 2.5);
            default:
                return strength;
        }
    }

    public int getDurability() {
        return durability;
    }

    public String getName() {
        return name;
    }
}
