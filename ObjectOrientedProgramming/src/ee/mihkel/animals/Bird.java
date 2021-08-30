package ee.mihkel.animals;

public class Bird extends Animal {
    private String country;
    private BirdColor birdColor;
    private int familyCount;
    private static int breedCount;

    public Bird(int price, int age, String name, String country, BirdColor birdColor) {
        super(price, age, name);
        this.country = country;
        this.birdColor = birdColor;
    }

    public void increaseAgeByOne() throws BirdAgeTooHighException {
        increaseAge();
        if (getAge() > 50) {
            throw new BirdAgeTooHighException("Vanus üle 50, viga");
        }
        System.out.println("VANUS UUENDATUD");
    }

    public int getFamilyCount() {
        return this.familyCount;
    }

    public void increaseFamilyCount() {
        this.familyCount++;
    }

    public int getBreedCount() {
        return Bird.breedCount;
    }

    public static int getAllBreedCount() {
        return Bird.breedCount;
    }

    public void increaseBreedCount() {
        Bird.breedCount++;
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
