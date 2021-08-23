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

        Mammal kass = new Mammal(100, 0, "Garfield", MammalType.KASS); // imiteerib uue asja loomist (kasutaja loomine, sisestab uue looma andmebaasi, uus tellimus
        Mammal koer = new Mammal(120,1, "Pluuto", MammalType.KOER);
        Mammal tiiger = new Mammal(2000,7, "King", MammalType.TIIGER);
        Mammal rott = new Mammal(30,4, "Miki", MammalType.ROTT);

        Mammal kassJunior1 = new Mammal(1,0,"Nr1", MammalType.KASS);
        Mammal kassJunior2 = new Mammal(1,0,"Nr2", MammalType.KASS);

        kass.addChild(kassJunior1);
        kass.addChild(kassJunior2);

        Mammal kassJunior3 = new Mammal(1,0,"Nr3", MammalType.KASS);
        kass.addChild(kassJunior3);

        Bird papagoi = new Bird(200, 8, "Pa", "LAV", BirdColor.RED);
        Bird ookull = new Bird(200, 2, "Oo", "Soome" , BirdColor.YELLOW);
        Bird tihane = new Bird(200, 5, "Ti", "Eesti", BirdColor.YELLOW_RED);
        Bird leevike = new Bird(200, 1, "Le", "Eesti", BirdColor.BLUE_YELLOW);

        Reptile kilpkonn = new Reptile(400,10,"Teen");
//        kilpkonn.age = 100;
        kilpkonn.setAge(100);
//        kilpkonn.name = "Teenage Ninja";
//        kilpkonn.price = 99;
        kilpkonn.setAsSold();
        System.out.println(kilpkonn);

        kass.setPrice(200);

        System.out.println(kass);
        System.out.println(koer);
        kass.setPrice(300);
        System.out.println(kass.getPrice());

        kass.setPrice(100);

        System.out.println(kass.isSold());
        kass.setAsSold();
        System.out.println(kass.isSold());

        System.out.println(papagoi);

        Flower flower = new Flower(3,false, Color.RED);
        Tree tree = new Tree(15,false,true);
    }
}
