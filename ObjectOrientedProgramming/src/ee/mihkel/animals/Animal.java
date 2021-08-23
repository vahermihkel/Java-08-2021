package ee.mihkel.animals;

import ee.mihkel.Sellable;

public abstract class Animal implements Sellable {
    private int price;
    private int age;
    private String name;
    private boolean isSold;

    public Animal(int price, int age, String name) {
        this.price = price;
        this.age = age;
        this.name = name;
        this.isSold = false;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setAge(int age) {
        this.age = age;
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
                ", isSold=" + isSold +
                '}';
    }
}
