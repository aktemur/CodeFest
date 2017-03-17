package pi;

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

    static int MAX = 50000000;

    public static void main(String[] args) {
        double pi = 0;
        long baslangic = System.currentTimeMillis();

        int icerdekiler = 0;

        for (int i = 0; i < MAX; i++) {
            double x = rastgele.nextDouble();
            double y = rastgele.nextDouble();
            double uzaklik = Math.sqrt(x*x + y*y);
            if (uzaklik <= 1) {
                icerdekiler++;
            }
        }
        pi = 4.0 * icerdekiler / MAX;

        long bitis = System.currentTimeMillis();
        long sure = bitis - baslangic;
        System.out.println("Toplam sure:          " + sure + " milisaniye.");
        System.out.println("Bulunan PI sayisi:    " + pi);
        System.out.println("Sistemdeki PI sayisi: " + PI);
        System.out.println("Hata (onbinde):       " + (10000 * abs(PI - pi) / PI));
    }
}
