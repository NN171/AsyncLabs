package Lab1;

import java.util.concurrent.CountDownLatch;

public class Writer implements Runnable {

//    private final CountDownLatch start;
//    private final CountDownLatch cdl;
    private final Book book;

    public Writer(Book book) {
//        this.cdl = cdl;
        this.book = book;
//        this.start = start;
    }

    @Override
    public void run() {
        try {
            book.write("abc");
        }
        catch (InterruptedException e) {
            System.err.println("Поток писателя: оишбка");
        }
    }
}
