package Lab1;

public class Book {

	private final StringBuilder content;
	private int users;
	private final int amount;
	private final BookGUI bookGUI;

	public Book(int amount, BookGUI bookGUI) {
		content = new StringBuilder();
		this.bookGUI = bookGUI;
		this.amount = amount;
	}

	public synchronized void write(String note) throws InterruptedException {
		while (users > 0) {
			wait();
		}

		users++;
		Thread.sleep(1000);
		content.append(note);
		System.out.println("Запись внесена");
		users--;
		notifyAll();
	}

	public synchronized String read() throws InterruptedException {
		while (users == amount) {
			wait();
		}
		users++;
		Thread.sleep(500);
		users--;
		notifyAll();
		return content.toString();
	}

	public String getContent() {
		return content.toString();
	}
}

