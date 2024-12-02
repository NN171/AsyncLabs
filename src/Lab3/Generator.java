package Lab3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generator {
	public static void generateMatrix(int n, String filePath) throws IOException {
		Random random = new Random();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					writer.write(random.nextInt(9) + " ");
				}
				writer.newLine();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int size = 10;
		String filePath = "D:/matrix.txt";
		generateMatrix(size, filePath);
		System.out.println("Матрица успешно создана и записана в файл: " + filePath);
	}
}
