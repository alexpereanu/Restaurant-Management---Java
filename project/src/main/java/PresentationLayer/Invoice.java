package PresentationLayer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Invoice {

    /**
     * Creates the invoice.
     *
     * @param Id the id
     * @param sumaDeAchitat the suma de achitat
     */
    public static void createInvoice(int Id, int sumaDeAchitat) {
        String fileName = "Chitanta.txt";
        try {
            PrintWriter outputStream = new PrintWriter(fileName);
            outputStream.println("CHITANTA");
            outputStream.println("Masa cu numarul " + Id + " are de platit suma de " + sumaDeAchitat + " lei");
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
