package ee.mihkel.character;

import ee.mihkel.World;
import ee.mihkel.item.Item;

import java.util.ArrayList;
import java.util.List;

// inheritance - pärilus ; saab kõik muutujad ja funktsioonid endasse millest extenditakse
// 1. koodikordus (xCoord, yCoord, symbol - getxCoord(), jne)
// 2. et saaks erinevaid klasse ühisesse Listi panna
// iga kord kui extendin pean subclassi lisama super() mis on täpselt selle constructori kujuga nagu parent classis

// encapsulation - kapseldus ; muutuja on nähtav ainult siin klassis kui tal on "private" ees
// avatakse see muutuja vaid kindlate funktsioonide kaudu (tüüpilised on getter ja setter)

// public ABSTRACT class - abstraktsioon ; seda klassi saab extendida, aga sellest klassist ei saa new Class() teha

// enum - kindlate väärtuste kogum, seda saan välja kutsuda ENUMI_KLASSI_NIMETUS.VÄÄRTUS
// enumi sees pole kohustuslik capsis väärtusi kirjutada, aga standard on

// int mingine = 0;
// boolean mingine2 = false;
// Item mingine3 = null;

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
            item.regenerateDurability();
            this.itemList.add(item);
        }
    }

    // public/private
    // void VÕI mingisugune tüüp mida tagastatakse (Item)
    // vabalt valitud funktsiooni nimetus, mis võiks tähendada mida ta teeb
    // sulgude sees:
    // alati ees mingisugune tüüp (String, int, boolean, Item, List) mille järel vabalt valitud muutuja nimetus
    // kui on võimalus panna muutuja nimeks tüüp väikse tähega, siis võiks seda ka teha
    // peaks olema võimalikult täpselt iseloomustav muutuja nimetus
    public void useItem(Item item) {
       item.decreaseDurability();
        if (item.getDurability() == 0) {
            this.deleteItem(item);
        }
    }

    public void deleteItem(Item item) {
        System.out.println(itemList);
        this.itemList.remove(item);
        System.out.println(itemList);
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
