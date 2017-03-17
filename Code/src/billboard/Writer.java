package billboard;

class Writer extends Thread {
    Billboard bb;

    public Writer(Billboard bb) {
        this.bb = bb;
    }

    public void run() {
        try {
            while(true) {
                bb.write("KEDIYI  YIKA");
                sleep(50);
                bb.write("ARABAYI  SAT");
                sleep(50);
            }
        } catch(InterruptedException e) {}
    }
}
