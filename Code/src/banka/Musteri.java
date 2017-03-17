package banka;

class Musteri extends Thread {
    private Hesap hesap;

    public Musteri(Hesap hesap) {
        this.hesap = hesap;
    }

    public void run() {
        for(int i = 0; i < 1000; i++) {
//            hesap.kilit.lock();
            hesap.paraYatir(1);
//            hesap.kilit.unlock();
        }
    }
}
