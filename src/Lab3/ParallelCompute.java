package Lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ParallelCompute extends RecursiveTask<Integer> {
	private final int[][] matrix;

	public ParallelCompute(int[][] matrix) {
		this.matrix = matrix;
	}

	@Override
	protected Integer compute() {
//		System.out.println(Thread.currentThread().getName());
		int size = matrix.length;
		if (size == 1) return matrix[0][0];
		if (size == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

		List<ParallelCompute> tasks = new ArrayList<>();
		int determinant = 0;

		for (int i = 0; i < size; i++) {
			int[][] minorMatrix = DeterminantCalc.minor(matrix, 0, i);
			ParallelCompute task = new ParallelCompute(minorMatrix);
			tasks.add(task);
			task.fork();
		}

		for (int i = 0; i < tasks.size(); i++) {
			determinant += (int) (Math.pow(-1, i) * matrix[0][i] * tasks.get(i).join());
		}

		return determinant;
	}

	public static int calculateDeterminant(int[][] matrix) {
		ParallelCompute task = new ParallelCompute(matrix);
//		return task.fork().join();
		return task.compute();
	}
}
