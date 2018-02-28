public class Produkt {
    private String name;
    private int number;
    private float price;

    public Produkt(String name, int number, float price) {
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public float getPrice() {
        return price;
    }
}
