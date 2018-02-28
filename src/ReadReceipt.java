import java.lang.*;

public class ReadReceipt {

    String input = "Śliwki:30:2.5/" +
            "Masło:20:6.20/" +
            "Kapusta:2:3/" +
            "Jabłka:5:4/" +
            "Margaryna:10:20/" +
            "Śliwki:10:2.5/" +
            "Majonez:8:4/" +
            "Jabłka:10:4/" +
            "Kapusta:5:3/" +
            "Śliwki:20:3.20/" +
            "Masło:2:3.33/" +
            "Kiełbasa:2:4.44/" +
            "Ciasto:4:2.22";

    private String[] listOfProducts = new String[getNumberOfProducts(input)];
    private int[] listOfPieces = new int[getNumberOfProducts(input)];
    private float[] listOfPrices = new float[getNumberOfProducts(input)];
    Produkt[] produkts = new Produkt[getNumberOfProducts(input)];

    public int getNumberOfProducts(String str) {
        char charToCheck = '/';
        int counter = 0;
        for (char ch : str.toCharArray()) {
            if (ch == charToCheck) counter++;
        }
        return counter + 1;
    }

    public void assignProducts(){
        String stringToSplit = input.replace(":","/");
        String[] splitInput = stringToSplit.split("/");

        for (int i = 0; i < splitInput.length/3; i++) {
            listOfProducts[i] = splitInput[3*i];
            listOfPieces[i] = Integer.parseInt(splitInput[3*i+1]);
            listOfPrices[i] = Float.parseFloat(splitInput[3*i+2]);
        }

        // Produkt[] produkts = new Produkt[splitInput.length];

        for (int i = 0; i < splitInput.length/3; i++) {
            produkts[i] = new Produkt(listOfProducts[i],listOfPieces[i],listOfPrices[i]);
        }

    }

    public float getTotalPrice(Produkt[] produkts){
        float totalPrice = 0;
        for (int i = 0; i < produkts.length; i++) {
            totalPrice = totalPrice + produkts[i].getPrice() * produkts[i].getNumber();
        }
        return totalPrice;
    }

    public void getRepeatedProducts(Produkt[] produkts) {

        for (int i = 0; i < produkts.length; i++) {
            Produkt aux = produkts[i];
                for (int j = 0; j < produkts.length; j++) {
                    if(produkts[i].getName().equals(produkts[j].getName())) {

                        if(produkts[i].getPrice() != produkts[j].getPrice()) {;
                        System.out.print("Uwaga! Rozna cena! ");
                        System.out.print(produkts[i].getName() + " / " + produkts[i].getPrice() + " - ");
                        System.out.print(produkts[j].getName() + " / " + produkts[j].getPrice() + "\n");
                        }

                    }

            }

        }


    }

    public void getTheMostExpensive(Produkt[] produkts) {

        float currentPrice = 0;
        String currentProduct = " ";
        int result;

        for (int i = 1; i < produkts.length; i++) {

            result = Float.compare(produkts[i].getPrice(),currentPrice);

                if(result == 1) {
                    currentPrice = produkts[i].getPrice();
                    currentProduct = produkts[i].getName();
                }

        }

        System.out.println("Najdrozszy produkt: " + currentProduct + " ,ktory kosztuje: " + currentPrice);

    }

    public int coins(double sum) {
        int quantity = 0;
        double[] tableCoin = {5, 2, 0.2, 0.1, 0.05, 0.01};
        String markCoins = "";
        if((sum%2) == 0) { markCoins = markCoins.concat((sum/2) + " szt monet " + " 2 zł" + "\n ");
        } else {
            for (double v : tableCoin) {
                quantity += (sum / v);
                markCoins = markCoins.concat((int) (sum / v) + " szt monet " + v + " zł" + "\n ");
                sum -= (int) (sum / v) * v;
            }
        }
        System.out.println(markCoins);
        return quantity;
    }

}
