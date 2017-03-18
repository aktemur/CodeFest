package banka;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Hesap {
    int bakiye = 0;
    Lock kilit = new ReentrantLock();

    public void paraYatir(int d) {
        kilit.lock();
        bakiye = bakiye + d;
        kilit.unlock();
    }

    public int bakiye() {
        return bakiye;
    }
}
