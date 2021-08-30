package ee.mihkel;

import ee.mihkel.animals.*;
import ee.mihkel.plants.Color;
import ee.mihkel.plants.Flower;
import ee.mihkel.plants.Plant;
import ee.mihkel.plants.Tree;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Animal suvaline = new Animal(1,4,"s");

        Mammal kass = new Mammal(100, 2, "Garfield", MammalType.KASS); // imiteerib uue asja loomist (kasutaja loomine, sisestab uue looma andmebaasi, uus tellimus
        Mammal koer = new Mammal(120,1, "Pluuto", MammalType.KOER);
        Mammal tiiger = new Mammal(2000,7, "King", MammalType.TIIGER);
        Mammal rott = new Mammal(30,4, "Miki", MammalType.ROTT);

        MainController.createKassChildren(kass);

        kass.increaseAgeByOne();

        Bird papagoi = new Bird(200, 8, "Pa", "LAV", BirdColor.RED);
        Bird ookull = new Bird(200, 2, "Oo", "Soome" , BirdColor.YELLOW);
        Bird tihane = new Bird(200, 5, "Ti", "Eesti", BirdColor.YELLOW_RED);
        Bird leevike = new Bird(200, 50, "Le", "Eesti", BirdColor.BLUE_YELLOW);

        try {
            leevike.increaseAgeByOne();
        } catch (BirdAgeTooHighException e) {
            e.printStackTrace();
        }

        MainController.createKilpkonn();

        System.out.println(koer);

        MainController.setCatPrice(kass);

        System.out.println(papagoi);

        Flower flower = new Flower(3,false, Color.RED);
        Tree tree = new Tree(15,false,true);

        System.out.println();

        MainController.printBirdCounts(papagoi);
        MainController.printBirdCounts(tihane);
        MainController.printBirdCounts(leevike);

    }
}
