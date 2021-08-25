package ee.mihkel.animals;

// private ja getterid/setterid - encapsulation
// parent-child relation, extends - inheritance
// ei ole võimalik new ClassiNimetus();, on ainult võimalik extendida - abstract classes
// parentis on mingisugune funktsioon mille kirjutame childis (alamklass) üle - polymorphism
// 1.implementeerimine interface-i mittelastes funktsiooni kustutada 2.sarnane tüüp - interface

// implements (interface) - lõpmatult palju kordi saab klassile külge panna
// extends (parent class) - 1 kord saab klassile külge panna

// overrides kirjutab midagi üle
// overloading - sama funktsioon või constructor mida saan teistsuguste parameetritega välja kutsuda


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mammal extends Animal {
    private boolean isPuppy;
    private MammalType mammalType;
    private List<Mammal> children = new ArrayList<>();

//    constructor overloading - erinevad võimalused new Mammal loomiseks
//    tavaliselt kasutatakse aga ainult 1 constructor klassis (all lihtsalt näide kuidas saaks)
    public Mammal(int _price, int _age, String _name, MammalType _mammalType) {
        super(_price, _age, _name);
        this.isPuppy = getAge() < 2;
        this.mammalType = _mammalType;
    }

    public Mammal(int _price, int _age, String _name) {
        super(_price, _age, _name);
        this.isPuppy = getAge() < 2;
        this.mammalType = MammalType.NOT_SELECTED;
    }

    public Mammal(int _age, String _name) {
        super(0, _age, _name);
        this.isPuppy = getAge() < 2;
        this.mammalType = MammalType.NOT_SELECTED;
    }

    public Mammal(int _age) {
        super(0, _age, "null");
        this.isPuppy = getAge() < 2;
        this.mammalType = MammalType.NOT_SELECTED;
    }

    public Mammal(int _price, int _age) {
        super(_price, _age, "null");
        this.isPuppy = getAge() < 2;
        this.mammalType = MammalType.NOT_SELECTED;
    }

    public List<Mammal> getChildren() {
        return children;
    }

    public void showChildren() {
        for (int i = 0; i < children.size(); i++) {
            System.out.println(i+1 + ". " + children.get(i).getName());
        }
    }

    public void getOneChild() {
        System.out.println("Ütle millise numbriga lapse nime soovid");
        Scanner scanner = new Scanner(System.in);
        String input; // deklareeritakse muutuja ja määratakse talle mälukoht
        Mammal child = null; // initsialiseeritakse muutuja ja antakse talle tühjus
        while (child == null) {
            try {
                input = scanner.nextLine(); // kui deklareeriks siin, siis saaks iga while tsükliga uue mälukoha
                int index = Integer.parseInt(input); // NumberFormatException
                child = children.get(index-1); // ArrayOutOfBoundsExc
                String childName = child.getName();
                System.out.println("Selle lapse nimi on: " + childName);
            } catch (NumberFormatException e) {
                System.out.println("Sisestasid numbri asemel tähe!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Sisestasid liiga suure või väikse numbri!");
            }
        }
    }

    public void increaseAgeByOne() {
        increaseAge();
        if (getAge() > 1) {
            this.isPuppy = false;
        }
    }

    private void addChild(Mammal child) {
        if (isPuppy) {
            System.out.println("Last ei saa lisada! Tegemist on kutsikaga");
        } else {
            this.children.add(child);
        }
    }

    public void addChild(Mammal child, boolean isTwin) {
        if (isTwin) {
            this.addChild(child);
            this.addChild(child);
        } else {
            this.addChild(child);
        }

    }

    public void removeChild(Mammal child) {
        this.children.remove(child);
    }

    @Override
    public int getPrice() {
        return getAge() * 4;
    }

    public boolean isPuppy() {
        return isPuppy;
    }

    public MammalType getMammalType() {
        return mammalType;
    }
}
