import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        String path = "D:\\Java-IntelliJ\\projects\\Summary_products\\products.txt";
        String[] phrases = new String[]{"TV LED,1290.99,1", "Video Game Chair,350.50,3" , "Iphone X,900.00,2" , "Samsung Galaxy 9,850.00,2"};

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            for (String phrase : phrases) {
                bw.write(phrase);
                bw.newLine();
            }


            String path2 = "D:\\Java-IntelliJ\\projects\\Summary_products\\out\\summary.csv";

            try (BufferedWriter bw2 = new BufferedWriter(new FileWriter(path2))){

                for (String phrase : phrases) {
                    String[] products = phrase.split(",");
                    double valueProduct = Double.parseDouble(products[1]);
                    int quantityProduct = Integer.parseInt(products[2]);
                    double totalQuantity = valueProduct * quantityProduct ;

                    bw2.write(products[0] + "," + String.format("%.2f", totalQuantity));
                    bw2.newLine();
                }
            }catch (IOException e) {
                e.printStackTrace();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}