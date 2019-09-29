package org.elsys.second;

public class NumberGenerator {

	private static int number;
	
	public static int nextNumber() {
		return ++number;
	}
}
