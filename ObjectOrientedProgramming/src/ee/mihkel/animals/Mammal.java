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

    public void addChild(Mammal child) {
        this.children.add(child);
    }

    public void removeChild(Mammal child) {
        this.children.remove(child);
    }

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
