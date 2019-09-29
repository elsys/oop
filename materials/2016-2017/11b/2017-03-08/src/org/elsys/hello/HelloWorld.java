package org.elsys.hello;

public class HelloWorld {
	private String message;

	public HelloWorld(String msg) {
		this.message = msg;
	}

	public HelloWorld() {
		this("Hello World");
	}

	
	public void print() {
		System.out.println(this.message);
	}

	public static void main(String[] args) {
		HelloWorld hw1 = new HelloWorld();
		HelloWorld hw2 = new HelloWorld("Good bye world!");

		hw1.print();
		hw2.print();

	}
}
