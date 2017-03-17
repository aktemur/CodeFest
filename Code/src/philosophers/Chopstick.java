package philosophers;

class Chopstick {
    int id;

    public Chopstick(int id) {
        this.id = id;
    }

    public void take(Philosopher taker) throws InterruptedException {
        System.out.println(taker + " " + this + "'in sahibi.");
    }

    public synchronized void put(Philosopher taker) {
        System.out.println(taker + " " + this + "'i birakti.");
    }

    public String toString() {
        return "Chopstick " + id;
    }
}
