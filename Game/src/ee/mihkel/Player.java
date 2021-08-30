package ee.mihkel;

import java.util.Random;

public class Player {
    private int xCoord;
    private int yCoord;
    private char symbol;

    public Player(World world) {
        this.xCoord = this.getRandomCoordinate(world.getWidth()-2);
        this.yCoord = this.getRandomCoordinate(world.getHeight()-2);
        this.symbol = 'X';
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

    public void move(String input, World world) {
        switch (input) {
            case "w":
                if (this.yCoord > 1) {
                    this.yCoord--;
                }
                break;
            case "s":
                if (this.yCoord < world.getHeight()-2) {
                    this.yCoord++;
                }
                break;
            case "a":
                if (this.xCoord > 1) {
                    this.xCoord--;
                }
                break;
            case "d":
                if (this.xCoord < world.getWidth()-2) {
                    this.xCoord++;
                }
                break;
        }
    }
}
