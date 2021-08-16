package ee.mihkel;

public class Animal {
    int price;
    int age;
    String name;
    boolean isPuppy;
    boolean isSold;

    public Animal(int _price, int _age, String _name) {
        this.price = _price;
        this.age = _age;
        this.name = _name;
        this.isPuppy = this.age < 2;
        this.isSold = false;
    }

    void setAsSold() {
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
