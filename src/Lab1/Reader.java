package Lab1;

public class Reader implements Runnable {

    private int count;

    public Reader() {
        this.count = 0;
    }

    @Override
    public void run() {
        while (count == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Поток читатель: ошибка");
            }
        }
    }
}
