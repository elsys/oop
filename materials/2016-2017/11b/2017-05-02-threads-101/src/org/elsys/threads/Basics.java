package org.elsys.threads;

public class Basics {

	public static void main(String[] args) {
		Thread th = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Hello from child thread!");
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
		
		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("bla bla");
				}
			}
		});
		th2.start();
		try {
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Exiting...");
	}

}






