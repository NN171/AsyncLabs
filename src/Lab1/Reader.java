package Lab1;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

public class Reader implements Runnable {

//    private final CountDownLatch start;
//    private final CountDownLatch cdl;
    private final Book book;
    private final String name;

    public Reader(Book book, String name) {
//        this.cdl = cdl;
        this.book = book;
        this.name = name;
//        this.start = start;
    }

    @Override
    public void run() {
        try {
            System.out.println(book.read());
        } catch (InterruptedException e) {
            System.err.println("Поток читатель: ошибка");
        }
    }
}
