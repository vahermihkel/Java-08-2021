package ee.mihkel;

public class Bird {
    int price;
    int age;
    String name;
    boolean isSold;
    String country;

    public Bird(int price, int age, String name, String country) {
        this.price = price;
        this.age = age;
        this.name = name;
        this.isSold = false;
        this.country = country;
    }

    void setAsSold() {
        this.isSold = true;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "price=" + price +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", isSold=" + isSold +
                ", country='" + country + '\'' +
                '}';
    }
}
