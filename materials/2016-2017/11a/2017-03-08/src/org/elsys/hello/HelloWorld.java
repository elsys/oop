package org.elsys.hello;

public class HelloWorld {

	private String message;

	public HelloWorld(String message) {
		this.message = message;
	}

	public HelloWorld() {
		this("Hello World!");
	}

	public void print() {
		System.out.println(message);
	}

	public static void main(String[] args) {
		HelloWorld hw1 = new HelloWorld();
		HelloWorld hw2 = new HelloWorld("Good Bye World!");

		hw1.print();
		hw2.print();
	}
}
