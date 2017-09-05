package main;

import consumidor.Consumidor;
import produtor.Produtor;

public class Main {
	public static void main(String[] args) {
		BoundedBuffer buffer = new BoundedBuffer(100);

		Produtor produtor1 = new Produtor(1, buffer);
		Produtor produtor2 = new Produtor(2, buffer);
		Produtor produtor3 = new Produtor(3, buffer);
		Consumidor consumidor1 = new Consumidor(1, buffer);
		Consumidor consumidor2 = new Consumidor(2, buffer);
		Consumidor consumidor3 = new Consumidor(3, buffer);

		produtor1.start();
		produtor2.start();
		produtor3.start();
		consumidor1.start();
		consumidor2.start();
		consumidor3.start();
	}
}
