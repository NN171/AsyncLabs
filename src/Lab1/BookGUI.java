package Lab1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class BookGUI extends JFrame {

    private final int writersCount = 40;
    private final int readersCount = 10;
    private final Book book;
    private final JTextArea contentArea;
    private final JTextArea statusArea;
    private final List<JProgressBar> readerProgressBars = new ArrayList<>();
    private final List<JProgressBar> writerProgressBars = new ArrayList<>();

    public BookGUI() {
        book = new Book(writersCount + readersCount, this);
        setTitle("Book Reader-Writer Simulation");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        contentArea = new JTextArea("Book content: some text");
        contentArea.setEditable(false);
        add(new JScrollPane(contentArea), BorderLayout.NORTH);

        statusArea = new JTextArea("Status: Waiting...");
        statusArea.setEditable(false);
        add(new JScrollPane(statusArea), BorderLayout.CENTER);

        JPanel progressPanel = new JPanel();
        progressPanel.setLayout(new GridLayout(8, 1));
        add(progressPanel, BorderLayout.SOUTH);

        for (int i = 1; i <= 5; i++) {
            JProgressBar readerProgress = new JProgressBar();
            readerProgress.setString("Reader " + i);
            readerProgress.setStringPainted(true);
            readerProgressBars.add(readerProgress);
            progressPanel.add(readerProgress);
        }

        for (int i = 1; i <= 3; i++) {
            JProgressBar writerProgress = new JProgressBar();
            writerProgress.setString("Writer " + i);
            writerProgress.setStringPainted(true);
            writerProgressBars.add(writerProgress);
            progressPanel.add(writerProgress);
        }

        JButton startButton = new JButton("Start Threads");
        startButton.addActionListener(e -> startSimulation());
        add(startButton, BorderLayout.NORTH);
    }

    private void startSimulation() {
        for (int i = 0; i < 3; i++) {
            new Writer(book, "Writer " + i, "New Content " + i, writerProgressBars.get(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            new Reader(book, "Reader " + i, readerProgressBars.get(i)).start();
        }
    }

    public void updateStatus(String message) {
        SwingUtilities.invokeLater(() -> statusArea.append(message + "\n"));
    }

    public void updateContent(String content) {
        SwingUtilities.invokeLater(() -> contentArea.setText("Book content: " + content));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookGUI gui = new BookGUI();
            gui.setVisible(true);
        });
    }
}

