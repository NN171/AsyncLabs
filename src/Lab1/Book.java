package Lab1;

public class Book {

	private final StringBuilder content;
	private int users;
	private final int amount;

	public Book(int amount) {
		content = new StringBuilder();
		this.amount = amount;
	}

	public synchronized void write(String note) throws InterruptedException {
		while (users > 0) {
			wait();
		}

		users++;
		Thread.sleep(200);
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
		Thread.sleep(50);
		users--;
		notifyAll();
		return content.toString();
	}

	public String getContent() {
		return content.toString();
	}
}
