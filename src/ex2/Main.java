package ex2;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] array = generateRandomArray(3000);

		SumThread[] threads = new SumThread[3];
		for (int i = 0; i < 3; i++) {
			threads[i] = new SumThread(array, i * 1000, (i + 1) * 1000);
			threads[i].start();
		}

		try {
			for (int i = 0; i < 3; i++) {
				threads[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int totalSum = 0;
		for (int i = 0; i < 3; i++) {
			totalSum += threads[i].getPartialSum();
		}

		System.out.println("Somma totale: " + totalSum);
	}

	private static int[] generateRandomArray(int size) {
		int[] array = new int[size];
		Random random = new Random();

		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(100);
		}

		return array;
	}
}
