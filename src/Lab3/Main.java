package Lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static int[][] readMatrix(String filePath, int size) throws IOException {
		int[][] matrix = new int[size][size];
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			for (int i = 0; i < size; i++) {
				String line = reader.readLine();
				if (line != null) {
					matrix[i] = Arrays.stream(line.trim().split(" "))
							.mapToInt(Integer::parseInt)
							.toArray();
				}
			}
		}
		return matrix;
	}

	public static void main(String[] args) throws IOException {
		String filePath = "C:/matrix.txt";
		int size = 10;
		int[][] matrix = readMatrix(filePath, size);

		long startTime = System.currentTimeMillis();
		int resultSingle = DeterminantCalc.calculateDeterminant(matrix);
		long endTime = System.currentTimeMillis();
		System.out.println("Однопоточный результат: " + resultSingle + " за " + (endTime - startTime) + " мс");

		startTime = System.currentTimeMillis();
		int resultParallel = ParallelCompute.calculateDeterminant(matrix);
		endTime = System.currentTimeMillis();
		System.out.println("Параллельный результат: " + resultParallel + " за " + (endTime - startTime) + " мс");
	}
}
