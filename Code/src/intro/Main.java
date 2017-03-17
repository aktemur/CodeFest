package intro;

import java.util.ArrayList;

public class Main {
    static ArrayList<Printer> printers = new ArrayList<>();
    static int NUM_PRINTERS = 10;

    public static void main(String[] args) throws InterruptedException {
        // Printer nesneleri olustur ve listeye at
        // Bu asamada Printer'lar sadece olusturuluyor, calistirma gerceklesmiyor
        for (int i = 0; i < NUM_PRINTERS; i++) {
            Printer printer = new Printer(i);
            printers.add(printer);
        }

        // Printer thread'leri baslat
        for (int i = 0; i < NUM_PRINTERS; i++) {
            printers.get(i).start();
        }

        // Printer thread'lerin bitmesini bekle
        for (int i = 0; i < NUM_PRINTERS; i++) {
            printers.get(i).join();
        }
    }
}
