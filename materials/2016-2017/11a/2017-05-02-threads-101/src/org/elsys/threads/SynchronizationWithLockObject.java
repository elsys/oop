package org.elsys.threads;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SynchronizationWithLockObject {

	private static long counter = 0;
	
	private static Object lock = new Object();
	
	public static void main(String[] args) {
		
		List<Thread> threads = IntStream.range(0, 10)
				.mapToObj(i -> new Thread(() -> {
					for (int j = 0; j < 100_000; j++) {
						synchronized (lock) {
							counter++;							
						}
					}
				}))
				.collect(Collectors.toList());

		//		(thread) -> thread.start()
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
		System.out.println("Counter value: " + counter);
		System.out.println("Time in ms:" + (finish - start));
	}

}
