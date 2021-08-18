package ee.mihkel;

public class Main {

    public static void main(String[] args) {

        Animal kass = new Animal(100, 0, "Garfield", AnimalType.KASS); // imiteerib uue asja loomist (kasutaja loomine, sisestab uue looma andmebaasi, uus tellimus
        Animal koer = new Animal(120,1, "Pluuto", AnimalType.KOER);
        Animal tiiger = new Animal(2000,7, "King", AnimalType.TIIGER);
        Animal rott = new Animal(30,4, "Miki", AnimalType.ROTT);

        Bird papagoi = new Bird(200, 8, "Pa", "LAV", BirdColor.RED);
        Bird ookull = new Bird(200, 2, "Oo", "Soome" , BirdColor.YELLOW);
        Bird tihane = new Bird(200, 5, "Ti", "Eesti", BirdColor.YELLOW_RED);
        Bird leevike = new Bird(200, 1, "Le", "Eesti", BirdColor.BLUE_YELLOW);

        Reptile kilpkonn = new Reptile();
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
    }
}
