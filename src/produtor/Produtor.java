package produtor;

import main.BoundedBuffer;

public class Produtor extends Thread {
	private int idThread;
	private int valor;
	private BoundedBuffer buffer;

	public Produtor(int idThread, BoundedBuffer buffer) {
		this.idThread = idThread;
		this.buffer = buffer;
	}

	public void put() {
		try {
			valor = (int)(Math.random() * 100 + 1);
			System.out.println("Thread Produtor #" + idThread + " colocando valor " + valor + " no buffer...");
			buffer.put(valor);
			Thread.sleep((long)(Math.random() * 500));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			put();
		}
	}
}