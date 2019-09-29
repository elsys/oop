package org.elsys.threads;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Table {

	private List<ReentrantLock> forks;

	public Table(int size) {
		forks = IntStream.range(0, size)
				.mapToObj(i -> new ReentrantLock())
				.collect(Collectors.toList());
	}

	public ReentrantLock getFork(int i) {
		return forks.get(i);
	}

	public int getSize() {
		return forks.size();
	}
}
