package ee.mihkel.character;

import ee.mihkel.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Character {
    private int xCoord;
    private int yCoord;
    private final char symbol;
    private boolean isVisible;
    protected double health;

    public Character(World world, char symbol) { // super(world, 'S')
        randomiseCoordinates(world);
        this.symbol = symbol;
        this.isVisible = true;
    }

    protected void randomiseCoordinates(World world) {
        this.xCoord = this.getRandomCoordinate(world.getWidth()-2); // 7
        this.yCoord = this.getRandomCoordinate(world.getHeight()-2); // 4
        checkCoordinatesUniqueness(world);
    }

    private void checkCoordinatesUniqueness(World world) {
        List<Character> characterListWithoutThis = new ArrayList<>();
        for (Character character: world.getCharacterList()) {
            if (character.symbol != this.symbol) {
                characterListWithoutThis.add(character);
            }
        }

        for (Character character: characterListWithoutThis) {
            if (character.getxCoord() == this.xCoord && character.getyCoord() == this.yCoord) {
                randomiseCoordinates(world);
                break;
            }
        }
    }

    private int getRandomCoordinate(int maxCoord) {
        Random random = new Random();
        return random.nextInt(maxCoord)+1;
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

    public void changeXCoordinate(boolean isIncrease) {
        if (isIncrease) {
            this.xCoord++;
        } else {
            this.xCoord--;
        }
    }

    public void changeYCoordinate(boolean isIncrease) {
        if (isIncrease) {
            this.yCoord++;
        } else {
            this.yCoord--;
        }
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public double getHealth() {
        return health;
    }

    public void takeHealth(int itemStrength) {
//        this.health = this.health - itemStrength;
        this.health -= itemStrength;
    }

    protected void reboost() {
        this.health = 10.0;
    }
}
