package ex2;

public class SumThread extends Thread {
	private int[] array;
	private int start;
	private int end;
	private int partialSum;

	public SumThread(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		partialSum = 0;
		for (int i = start; i < end; i++) {
			partialSum += array[i];
		}
	}

	public int getPartialSum() {
		return partialSum;
	}
}
