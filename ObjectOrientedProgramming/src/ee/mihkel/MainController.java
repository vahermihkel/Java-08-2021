package ee.mihkel;

import ee.mihkel.animals.Bird;
import ee.mihkel.animals.Mammal;
import ee.mihkel.animals.MammalType;
import ee.mihkel.animals.Reptile;

public class MainController {
    public static void printBirdCounts(Bird bird) {
        bird.increaseFamilyCount();
        System.out.println(bird.getFamilyCount());
        bird.increaseBreedCount();
        System.out.println(bird.getBreedCount());
        System.out.println(Bird.getAllBreedCount());
    }

    public static void createKilpkonn() {
        Reptile kilpkonn = new Reptile(400,10,"Teen");
//        kilpkonn.age = 100;
//        kilpkonn.setAge(100);
//        kilpkonn.name = "Teenage Ninja";
//        kilpkonn.price = 99;
        kilpkonn.setAsSold();
        System.out.println(kilpkonn);
    }

    public static void setCatPrice(Mammal kass) {
        kass.setPrice(200);

        System.out.println(kass);
        kass.setPrice(300);
        System.out.println(kass.getPrice());

        kass.setPrice(100);

        System.out.println(kass.isSold());
        kass.setAsSold();
        System.out.println(kass.isSold());
    }

    public static void createKassChildren(Mammal kass) {
        Mammal kassJunior1 = new Mammal(1,0,"Nr1", MammalType.KASS);
        Mammal kassJunior2 = new Mammal(1,0,"Nr2", MammalType.KASS);

        kass.addChild(kassJunior1, true);
        kass.addChild(kassJunior2, false);

        Mammal kassJunior3 = new Mammal(1,0,"Nr3", MammalType.KASS);
        kass.addChild(kassJunior3, false);

        kass.showChildren();
        kass.getOneChild();

        kassJunior1.addChild(kassJunior2, true);
    }
}
