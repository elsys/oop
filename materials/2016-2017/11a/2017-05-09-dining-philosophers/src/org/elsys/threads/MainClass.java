package org.elsys.threads;

public class MainClass {

	public static void main(String[] args) {
		Table table = new Table(5);
		for (int i = 0; i < 5; i++) {
			new Thread(new Philosopher(table, i)).start();;
		}
	}

}
