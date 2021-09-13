package ee.mihkel;

import ee.mihkel.character.Character;
import ee.mihkel.item.Item;

import java.util.ArrayList;
import java.util.List;

public class World {
    private int height;
    private int width;
    private List<Character> characterList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();

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

    public void addCharacter(Character character) {
        this.characterList.add(character);
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void printMap() {
        char symbol;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == 0 || y == height-1) { // esimene VÕI teine peab tõene olema, et terve avaldis tõene
                    symbol = '-';
                } else if (x == 0 || x == width-1) {
                    symbol = '|';
                } else {
                    symbol = ' ';

                    for (Item item: itemList) {
                        if (item.getyCoord() == y && item.getxCoord() == x) { // esimene JA teine peavad
                            symbol = item.getSymbol();         // mõlemad olema tõesed, et terve avaldis oleks tõene
                        }
                    }

                    // for (Item item: itemList)      [item1,item2,item3]
                    // Item item = item1
                    // item1 võetakse y coord ja x coord võrreldakse seda x ja y'ga for tsüklis
                    // ja kui item1 ja fortsükli x ja y võrduvad, siis sümbol saab endale väärtuseks eseme sümbol
                    // tsükkel lõppeb

                    // Item item = item2

                    for (Character character : characterList) {
                        if (character.getyCoord() == y && character.getxCoord() == x && character.isVisible()) { // esimene JA teine peavad
                            symbol = character.getSymbol();         // mõlemad olema tõesed, et terve avaldis oleks tõene
                        }
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }

    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }
}


