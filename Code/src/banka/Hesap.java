package banka;

class Hesap {
    private int bakiye = 0;

    public void paraYatir(int d) {
        bakiye += d;
    }

    public int bakiye() {
        return bakiye;
    }
}
