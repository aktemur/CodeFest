package billboard;

class Billboard {
    final int LENGTH = 12;
    char[] signs = new char[LENGTH];

    public void write(String message) throws InterruptedException {
        if (message.length() != signs.length) {
            throw new IllegalArgumentException("Mesaj uzunlugu su olmali: " + signs.length);
        }
        for(int i = 0; i < signs.length; i++) {
            Thread.sleep(10); // Tabelayi yerlestirmek vakit aliyor
            signs[i] = message.charAt(i);
        }
    }

    public String read() throws InterruptedException {
        String message = "";
        for(int i = 0; i < signs.length; i++) {
            Thread.sleep(2); // Tabelayi okumak vakit aliyor
            message += signs[i];
        }
        return message;
    }
}
