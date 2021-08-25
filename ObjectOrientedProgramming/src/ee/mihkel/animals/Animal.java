package ee.mihkel.animals;

import ee.mihkel.Sellable;

import java.util.Scanner;

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

    public Animal(int price, int age) {
        this.price = price;
        this.age = age;
        this.name = "N/A";
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

    protected void increaseAge() {
//        this.age = this.age + 1;
//        this.age += 1;
        this.age++;
    }

    public void setAsSold() {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect = false;
        while (!isCorrect) {
            System.out.println("Kas on vajalikud dokumendid esitatud?");
            String input = scanner.nextLine();
            if (input.equals("y")) {
                this.isSold = true;
                isCorrect = true;
            } else if (input.equals("n")) {
                System.out.println("Dokumendid esitamata, müüa ei saa!");
                isCorrect = true;
            } else {
                isCorrect = false;
                System.out.println("Sisesta 'y' või 'n' täht");
            }
        }
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
