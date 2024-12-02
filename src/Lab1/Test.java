package Lab1;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

public class Test {
	public static void main(String[] args) throws InterruptedException {

		int n = 1000;
		CountDownLatch cdl = new CountDownLatch(n*2);
		CountDownLatch start = new CountDownLatch(1);
//		Book book = new Book(5);

		for (int i = 0; i < n; i++) {
//			new Thread(new Writer(start, cdl, book)).start();
//			new Thread(new Reader(start, cdl, book)).start();
		}

		start.countDown();

		cdl.await();
	}
}
