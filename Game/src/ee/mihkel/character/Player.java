package ee.mihkel.character;

import ee.mihkel.World;
import ee.mihkel.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {
    private Direction direction;
    private List<Item> itemList = new ArrayList<>();

    public Player(World world) {
        super(world, 'X');
        this.direction = Direction.UP;
    }

    public void addItem(Item item) {
        boolean isItem = this.itemList.contains(item);
        if (isItem) {
            item.increaseDurability();
        } else {
            this.itemList.add(item);
        }
    }

    public void deleteItem(Item item) {
        this.itemList.remove(item);
    }

    public void showAllItems() {
        if (!isNoItems()) {
            System.out.println("Ütle millist eset tahad: ");
            int index = 1;
            for (Item item: itemList) {
                System.out.println(index + ". Ese: " + item.getName() + "(" + item.getStrength() + "), kasutuskordi: " + item.getDurability());
                index++;
            }
        }
    }

    public boolean isNoItems() {
        return itemList.isEmpty();
    }

    public void move(String input, World world) {
        switch (input) {
            case "w":
                this.direction = Direction.UP;
                break;
            case "s":
                this.direction = Direction.DOWN;
                break;
            case "a":
                this.direction = Direction.LEFT;
                break;
            case "d":
                this.direction = Direction.RIGHT;
                break;
        }
        switch (direction) {
            case UP:
                if (getyCoord() > 1) {
                    changeYCoordinate(false);
                }
                break;
            case DOWN:
                if (getyCoord() < world.getHeight()-2) {
                    changeYCoordinate(true);
                }
                break;
            case LEFT:
                if (getxCoord() > 1) {
                    changeXCoordinate(false);
                }
                break;
            case RIGHT:
                if (getxCoord() < world.getWidth()-2) {
                    changeXCoordinate(true);
                }
                break;
        }
    }

    public Item getItemFromList(int index) {
        return itemList.get(index-1);
    }
}
