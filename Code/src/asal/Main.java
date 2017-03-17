package asal;

import java.util.LinkedList;

/**
 * Problem:
 * 0 ve MAX arasinda kac tane asal sayilari oldugunu bulunuz.
 *
 * Arama yaptiginiz araligi bolup her bir araligi bir thread'e
 * vererek islemi hizlandirabilir misiniz?
 *
 * Her bir thread'in aldigi toplam sureyi de olcun.
 * Dengeli bir dagilim oldu mu?
 *
 */

public class Main {
    static boolean asal(int n) {
        for (int i = 3; i < n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int MAX = 500000;

    public static void main(String[] args) {
        long baslangic = System.currentTimeMillis();

        int asalAdedi = 0;
        for (int i = 3; i < MAX; i += 2) {
            if (asal(i)) {
                asalAdedi++;
            }
        }

        long bitis = System.currentTimeMillis();
        long sure = bitis - baslangic;
        System.out.println("Toplam sure: " + sure + " milisaniye.");

        System.out.println(asalAdedi + " adet asal sayi bulundu.");
    }
}
