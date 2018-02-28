/*  Application of arrays instead of lists in this example is intentional */

public class Main {

    public static void main(String[] args) {

        ReadReceipt reader = new ReadReceipt();

        reader.assignProducts();
        System.out.println("Liczba produktow: " + reader.getNumberOfProducts(reader.input));
        System.out.println("Calkowita cena to: " + reader.getTotalPrice(reader.produkts) + " PLN");

        reader.getRepeatedProducts(reader.produkts);

        reader.getTheMostExpensive(reader.produkts);

        System.out.println(reader.coins(reader.getTotalPrice(reader.produkts)));

    }

}
