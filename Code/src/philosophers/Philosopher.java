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

                leftStick.take(this);
                rightStick.take(this);

                eat();

                leftStick.put(this);
                rightStick.put(this);

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
