package ee.mihkel;

import java.util.ArrayList;
import java.util.List;

public class World {
    private int height;
    private int width;
    private List<Player> playerList = new ArrayList<>();

    public World(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void addPlayer(Player player) {
        this.playerList.add(player);
    }

    public void printMap() {
        char symbol;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == 0 || y == height-1) {
                    symbol = '-';
                } else if (x == 0 || x == width-1) {
                    symbol = '|';
                } else {
                    symbol = ' ';
                    for (Player player : playerList) {
                        if (player.getyCoord() == y && player.getxCoord() == x) {
                            symbol = player.getSymbol();
                        }
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }

    }
}
