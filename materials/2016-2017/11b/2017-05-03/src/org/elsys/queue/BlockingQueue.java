package org.elsys.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public class BlockingQueue<T> {

	private Queue<T> queue = new LinkedList<T>();
	final private int capacity;

	public BlockingQueue(int capacity) {
		this.capacity = capacity;
	}

	private boolean isFull() {
		return queue.size() >= capacity;
	}

	public synchronized void put(T task) {
		while (isFull()) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		queue.add(task);
		notifyAll();
	}

	public synchronized T take() {
		while (queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		T task = queue.poll();
		notifyAll();
		return task;
	}

	private static AtomicLong producersCount = new AtomicLong(0);

	public static void main(String[] args) {
		BlockingQueue<String> queue = new BlockingQueue<String>(10);

		List<Thread> producers = new LinkedList<Thread>();

		for (int i = 0; i < 10; i++) {
			producers.add(new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						String task = "task" + producersCount.incrementAndGet();
						System.out.println("going to add taks <" + task + ">...");
						queue.put(task);
						System.out.println("task <" + task + "> added...");
					}
				}
			}));
		}

		for (Thread p : producers) {
			p.start();
		}

		List<Thread> consumers = new LinkedList<Thread>();
		for (int i = 0; i < 5; ++i) {
			consumers.add(new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						try {
							Thread.sleep(2000);
							String task = queue.take();
							System.out.println("task <" + task + "> consumed...");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}

			}));
		}
		for (Thread c : consumers) {
			c.start();
		}

		for (Thread c : consumers) {
			try {
				c.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
