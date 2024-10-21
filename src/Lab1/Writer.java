package Lab1;

public class Writer implements Runnable {

    private int count;

    public Writer() {
        this.count = 0;
    }

    @Override
    public void run() {
        try {
            while (count == 1) {
                wait();
            }

            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.err.println("Поток писателя: оишбка");
        }

        count++;
    }
}
