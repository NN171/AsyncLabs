package Lab3;

public class DeterminantCalc {

	public static int[][] minor(int[][] matrix, int row, int col) {
		int size = matrix.length;
		int[][] minor = new int[size - 1][size - 1];

		for (int i = 0, mi = 0; i < size; i++) {
			if (i == row) continue;
			for (int j = 0, mj = 0; j < size; j++) {
				if (j == col) continue;
				minor[mi][mj++] = matrix[i][j];
			}
			mi++;
		}
		return minor;
	}

	public static int calculateDeterminant(int[][] matrix) {
		int size = matrix.length;
		if (size == 1) return matrix[0][0];
		if (size == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

		int determinant = 0;
		for (int i = 0; i < size; i++) {
			int[][] minorMatrix = minor(matrix, 0, i);
			determinant += (int) (Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(minorMatrix));
		}
		return determinant;
	}
}
