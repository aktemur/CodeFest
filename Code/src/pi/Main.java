package pi;

import java.util.ArrayList;
import java.util.Random;
import static java.lang.Math.*;

/**
 * Problem:
 * Pi sayisini Monte Carlo simulasyonu yontemi ile yaklasik olarak hesaplayin.
 *
 * Islemi thread'ler vasitasiyla eszamanli olarak yaparak
 * toplam sureyi dusurebilir misiniz?
 *
 */

public class Main {
    // Tutarli olcumler yapabilmek icin sabit bir
    // "seed" (tohum) degeri ile olustur.
    static Random rastgele = new Random(0);

    static int MAX = 100000000;

    static ArrayList<PiBulucu> threadler = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        double pi = 0;

        for (int i = 0; i < 8; i++) {
            threadler.add(new PiBulucu(i, MAX/8));
        }

        long baslangic = System.currentTimeMillis();

        for (int i = 0; i < 8; i++) {
            threadler.get(i).start();
        }
        for (int i = 0; i < 8; i++) {
            threadler.get(i).join();
        }

        int iceridekiler = 0;
        for (int i = 0; i < 8; i++) {
            iceridekiler += threadler.get(i).iceridekiler;
        }

        pi = 4.0 * iceridekiler / MAX;

        long bitis = System.currentTimeMillis();
        long sure = bitis - baslangic;
        System.out.println("Toplam sure:          " + sure + " milisaniye.");
        System.out.println("Bulunan PI sayisi:    " + pi);
        System.out.println("Sistemdeki PI sayisi: " + PI);
        System.out.println("Hata (onbinde):       " + (10000 * abs(PI - pi) / PI));
    }
}
