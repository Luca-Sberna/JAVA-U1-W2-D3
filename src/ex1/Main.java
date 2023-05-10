package ex1;

public class Main {

	public static void main(String[] args) {
		Thread thread1 = new SymbolThread("*");
		Thread thread2 = new SymbolThread("#");

		thread1.start();
		thread2.start();
	}

	private static class SymbolThread extends Thread {
		private String symbol;

		public SymbolThread(String symbol) {
			this.symbol = symbol;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(symbol);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
