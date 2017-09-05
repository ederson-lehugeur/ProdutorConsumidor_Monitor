package consumidor;

import main.BoundedBuffer;

public class Consumidor extends Thread {
	private int idThread;
	private int valor;
	private BoundedBuffer buffer;

	public Consumidor(int idThread, BoundedBuffer buffer) {
		this.idThread = idThread;
		this.buffer = buffer;
	}

	public void get() {
		try {
			valor = buffer.get();
			System.out.println("Thread Consumidor #" + idThread + " retirando valor " + valor + " do buffer...");
			Thread.sleep((long)(Math.random() * 500));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			get();
		}
	}
}
