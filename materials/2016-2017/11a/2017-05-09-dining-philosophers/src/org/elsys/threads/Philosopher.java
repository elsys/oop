package org.elsys.threads;

import java.util.Random;

public class Philosopher implements Runnable {

	private Table table;
	private int position;

	public Philosopher(Table table, int position) {
		this.position = position;
		this.table = table;
	}
	@Override
	public void run() {
		while (true) {
			think();
			getForks();
			eat();
			putForks();
		}
	}

	private void putForks() {
		System.out.println("Finished eating...");
		table.getFork(position).unlock();;
		table.getFork((position + 1) % table.getSize()).unlock();
	}

	private void getForks() {
		System.out.println("I'm feeling hungry...");
		table.getFork(position).lock();
		table.getFork((position + 1) % table.getSize()).lock();
	}
	
	private void think() {
		try {
			System.out.println("I'll think a bit...");
			Thread.sleep(new Random().nextInt(10));
		} catch (InterruptedException e) {
		}
	}
	

	private void eat() {
		try {
			System.out.println("I'll eat...");
			Thread.sleep(new Random().nextInt(10));
		} catch (InterruptedException e) {
		}
	}

}
