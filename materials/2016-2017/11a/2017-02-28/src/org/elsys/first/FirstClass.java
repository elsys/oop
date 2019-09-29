package org.elsys.first;

import java.util.Date;

public class FirstClass {

	public static void main(String[] args) {
		while (true) {
			System.out.println("Hello, Java world!");
			Date date = new Date();
			if (date.getTime() % 3 == 0) {
				break;
			}
		}
		System.out.println("Finally got out of the loop.");

		org.elsys.first.task.Task newTask = new org.elsys.first.task.Task();
		
	}
}
