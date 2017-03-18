package pi;

import java.util.Random;

public class PiBulucu extends Thread {
    int iceridekiler;
    int N;
    Random rastgele;

    PiBulucu(int id, int n) {
        N = n;
        rastgele = new Random(id);
    }

    public void run() {
        for (int i = 0; i < N; i++) {
            double x = rastgele.nextDouble(); // 0-1 arasinda
            double y = rastgele.nextDouble(); // 0-1 arasinda
            double uzaklik = Math.sqrt(x*x + y*y);
            if (uzaklik <= 1) {
                iceridekiler++;
            }
        }
    }
}
