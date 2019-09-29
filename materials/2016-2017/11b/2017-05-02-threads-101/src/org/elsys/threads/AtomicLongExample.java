package org.elsys.threads;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AtomicLongExample {

	private static AtomicLong counter = new AtomicLong(0);
	
	public static void main(String[] args) {
		List<Thread> threads = IntStream.range(0, 10)
				.mapToObj(i -> new Thread(() -> {
					for (int j = 0; j < 100_000; j++) {
						counter.getAndIncrement();
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

}
