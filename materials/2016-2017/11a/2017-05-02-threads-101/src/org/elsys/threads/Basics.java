package org.elsys.threads;

public class Basics {

	public static void main(String[] args) {
		Thread th = new Thread() {
			@Override
			public void run() {
				try {
					// time in ms
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Hello from second thread!");
			}
		};
		th.start();
		System.out.println("Hello from main thread before joining!");
		try {
			th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello from main thread after joining!");
	}

}
