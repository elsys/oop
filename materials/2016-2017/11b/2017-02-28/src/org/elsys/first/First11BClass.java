package org.elsys.first;

import java.util.Date;

public class First11BClass {

	public static void main(String[] args) {
		while (true) {
			System.out.println("Still in loop!");
			Date now = new Date();
			if (now.getTime() % 3 == 0) {
				break;
			}
		}
		System.out.println("Hello, Java world!");
	}
}
