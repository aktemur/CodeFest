package philosophers;

class Philosopher extends Thread {
    int id;
    Chopstick leftStick;
    Chopstick rightStick;

    public Philosopher(int n, Chopstick left, Chopstick right) {
        id = n;
        leftStick = left;
        rightStick = right;
    }

    public void run() {
        while(true) {
            try{
                think();

                // DIKKAT: Bu cozum herkesin birbirini beklemesi
                // anlamina gelen "deadlock" durumuna neden olabilir.
                leftStick.kilit.lock();
                leftStick.take(this);
                rightStick.kilit.lock();
                rightStick.take(this);

                eat();

                leftStick.put(this);
                leftStick.kilit.unlock();
                rightStick.put(this);
                rightStick.kilit.unlock();

            } catch(InterruptedException e) {
                return;
            }
        }
    }

    private void think() throws InterruptedException {
        sleep(500);
        System.out.println(this + " derin dusuncelere daldi...");
    }

    private void eat() throws InterruptedException {
        sleep(200);
        System.out.println(this + " hapur hupur yiyor...");
    }

    public String toString() {
        return "Filozof " + id;
    }
}
