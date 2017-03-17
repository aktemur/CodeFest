package banka;

import java.util.*;

public class Banka {
    static int MUSTERI_SAYISI = 2;
    
    public static void main(String[] args) throws InterruptedException {
        List<Musteri> musteriler = new ArrayList<Musteri>();
        Hesap ortakHesap = new Hesap();
        
        for (int i = 0; i < MUSTERI_SAYISI; i++) {
            Musteri musteri = new Musteri(ortakHesap);
            musteriler.add(musteri);
        }

        // Musteriler ortak hesaba para yatirmaya baslasinlar
        for (Musteri customer : musteriler) {
            customer.start();
        }

        // Islemlerin bitmesini bekle
        for (Musteri customer : musteriler) {
            customer.join();
        }

        System.out.println("Son durumda bakiye: " + ortakHesap.bakiye());
    }
}

