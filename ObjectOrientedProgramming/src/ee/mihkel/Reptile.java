package ee.mihkel;

public class Reptile {
    private int price;
    private int age;
    private String name;
    private boolean isSold;

    public void setAge(int age) {
        this.age = age;
    }

//    public void setSold(boolean sold) {
//        isSold = sold;
//    }

    void setAsSold() {
        this.isSold = true;
    }

    @Override
    public String toString() {
        return "Reptile{" +
                "price=" + price +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", isSold=" + isSold +
                '}';
    }
}
