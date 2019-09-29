package org.elsys.threads;

import java.util.Random;

public class Philosopher implements Runnable {

	private Table table;
	private int position;
	private String name;

	public Philosopher(String name, Table table, int position) {
		this.table = table;
		this.position = position;
		this.name = name;
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
		System.out.println(name + " finished eating...");
		table.getFork(position).unlock();
		table.getFork((position + 1) % table.size()).unlock();
	}

	private void eat() {
		System.out.println(name + "'s eating...");
		try {
			Thread.sleep(new Random().nextInt(5));
		} catch (InterruptedException e) {
		}
	}

	private void getForks() {
		System.out.println(name + " thinks he is feeling hungry...");
		if (position % table.size() == 1) {
			table.getFork(position).lock();
			table.getFork((position + 1) % table.size()).lock();			
		} else {
			table.getFork((position + 1) % table.size()).lock();
			table.getFork(position).lock();
		}
	}

	private void think() {
		System.out.println(name + " thinks he's going to think...");
		try {
			Thread.sleep(new Random().nextInt(5));
		} catch (InterruptedException e) {
		}
	}

}
