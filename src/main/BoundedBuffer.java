package main;

public class BoundedBuffer {
	private int inicio;
	private int fim;
	private int qtdElementos;
	private int limite;
	private int buffer[];

	public BoundedBuffer(int limite) {
		this.inicio = 0;
		this.fim = 0;
		this.qtdElementos = 0;
		this.limite = limite;
		this.buffer = new int[limite];
	}

	public synchronized void put(int valor) throws InterruptedException {
		while (qtdElementos == limite)
			wait();
		buffer[fim++ % limite] = valor;
		qtdElementos++;
		notifyAll();
	}

	public synchronized int get() throws InterruptedException {
		while (qtdElementos == 0)
			wait();
		int valor = buffer[inicio++ % limite];
		qtdElementos--;
		notifyAll();

		return valor;
	}
}
