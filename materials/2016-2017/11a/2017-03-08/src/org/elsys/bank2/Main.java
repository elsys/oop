package org.elsys.bank2;

public class Main {

	public static void main(String[] args) {
		CheckingAccount a1 = new CheckingAccount(100);
		a1.deposit(100);
		a1.deposit(200);

		System.out.println("a1 balance: " + a1.getBalance());

		a1.withdraw(1000);
		System.out.println("a1 balance: " + a1.getBalance());

		SavingsAccount a2 = new SavingsAccount(1000);
		a2.withdraw(1);
		a2.withdraw(1);

		System.out.println("a2 balance: " + a2.getBalance());

		a2.withdraw(1);
		a2.withdraw(1);
		// a2.withdraw(1);
		a2.resetNumberOfWithdrawals();

		BankAccount accounts[] = { a1, a2 };
		for (BankAccount acc : accounts) {
			acc.deposit(100);
			System.out.println("balance: " + acc.getBalance());
			acc.withdraw(50);
			System.out.println("balance: " + acc.getBalance());
		}

	}

}
