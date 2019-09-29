package org.elsys.second;

public class IdInitializer {
	
	private static long id;
	
	public static long nextId() {
		return incAndGet();
	}

	private static long incAndGet() {
		return id++;
	}
}
