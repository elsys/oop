package org.elsys.threads;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Synchronizing {

	private static long counter = 0;
	
	private static Object lock = new Object();
	
	public static void main(String[] args) {
		
		List<Thread> threads = IntStream.range(0, 10)
				.mapToObj(i -> new Thread(() -> {
					for (int j = 0; j < 100_000; j++) {
						// acquire lock
						synchronized (lock) {
							counter++;
							// int copy = counter;
							// copy = copy + 1;
							// counter = copy;
						}
						// release lock
					}
				}))
				.collect(Collectors.toList());
		long start = new Date().getTime();
		threads.forEach(Thread::start);
		threads.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long finish = new Date().getTime();
		System.out.println("Final value of counter: " + counter);
		System.out.println("Time in ms: " + (finish - start));
	}
	
	private static synchronized void incr() {
		counter++;
	}
	
	private synchronized void incr_() {
		// synchronized on this
	}
}
