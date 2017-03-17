package intro;

public class Printer extends Thread {
    int id;

    Printer(int n) {
        id = n;
    }

    public void run() {
        for (int i = 0; i < 1000000; i++) {
            System.out.println("Printer " + id + " : " + i);
        }
    }
}
