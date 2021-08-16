package ee.mihkel;

public class Main {

    public static void main(String[] args) {

        Animal kass = new Animal(100, 0, "Garfield"); // imiteerib uue asja loomist (kasutaja loomine, sisestab uue looma andmebaasi, uus tellimus
        Animal koer = new Animal(120,1, "Pluuto");
        Animal tiiger = new Animal(2000,7, "King");
        Animal rott = new Animal(30,4, "Miki");

        Bird papagoi = new Bird(200, 8, "Pa", "LAV");
        Bird ookull = new Bird(200, 2, "Oo", "Soome");
        Bird tihane = new Bird(200, 5, "Ti", "Eesti");
        Bird leevike = new Bird(200, 1, "Le", "Eesti");

        System.out.println(kass);
        System.out.println(koer);
        System.out.println(kass.price);

        System.out.println(kass.isSold);
        kass.setAsSold();
        System.out.println(kass.isSold);
    }
}
