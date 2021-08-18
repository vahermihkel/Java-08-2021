package ee.mihkel;

public class Bird {
    private int price;
    private int age;
    private String name;
    private boolean isSold;
    private String country;
    private BirdColor birdColor;

    public Bird(int price, int age, String name, String country, BirdColor birdColor) {
        this.price = price;
        this.age = age;
        this.name = name;
        this.isSold = false;
        this.country = country;
        this.birdColor = birdColor;
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
                ", birdColor=" + birdColor +
                '}';
    }
}
