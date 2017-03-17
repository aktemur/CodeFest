package banka;

class Hesap {
    int bakiye = 0;

    public void paraYatir(int d) {
        bakiye += d;
    }

    public int bakiye() {
        return bakiye;
    }
}
