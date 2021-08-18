package ee.mihkel;

// encapsulation

public class Animal {
    private int price;
    private int age;
    private String name;
    private boolean isPuppy;
    private boolean isSold;
    private AnimalType animalType;

    public Animal(int _price, int _age, String _name, AnimalType _animalType) {
        this.price = _price;
        this.age = _age;
        this.name = _name;
        this.isPuppy = this.age < 2;
        this.isSold = false;
        this.animalType = _animalType;
    }

    public int getPrice() {
        return price;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAsSold() {
        this.isSold = true;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "price=" + price +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", isPuppy=" + isPuppy +
                ", isSold=" + isSold +
                '}';
    }
}
