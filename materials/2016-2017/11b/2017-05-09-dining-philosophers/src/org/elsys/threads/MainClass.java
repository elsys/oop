package org.elsys.threads;

public class MainClass {

	public static void main(String[] args) {
		String[] names = new String [] {
				"Socrates", "Aristotle", "Plato", "Pithagores", "Euclid"
		};
		Table table = new Table(5);
		for (int i = 0; i < 5; i++) {
			new Thread(new Philosopher(names[i], table, i)).start();
		}
	}
}
