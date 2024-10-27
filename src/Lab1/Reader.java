package Lab1;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

public class Reader implements Runnable {

    private final CountDownLatch start;
    private final CountDownLatch cdl;
    private final Book book;

    public Reader(CountDownLatch start, CountDownLatch cdl, Book book) {
        this.cdl = cdl;
        this.book = book;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            start.await();
            System.out.println(book.read());
            cdl.countDown();
        } catch (InterruptedException e) {
            System.err.println("Поток читатель: ошибка");
        }
    }
}
