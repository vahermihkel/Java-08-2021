package ee.mihkel.animals;

public class Bird extends Animal {
    private String country;
    private BirdColor birdColor;

    public Bird(int price, int age, String name, String country, BirdColor birdColor) {
        super(price, age, name);
        this.country = country;
        this.birdColor = birdColor;
    }


    @Override
    public String toString() {
        return "Bird{" +
                "price=" + getPrice() +
                ", age=" + getAge() +
                ", name='" + getName() + '\'' +
                ", isSold=" + isSold() +
                ", country='" + country + '\'' +
                ", birdColor=" + birdColor +
                '}';
    }
}
