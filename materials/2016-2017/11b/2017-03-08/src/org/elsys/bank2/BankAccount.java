package org.elsys.bank2;

public abstract class BankAccount {
	protected int balance;

	public int getBalance() {
		return balance;
	}

	public void deposit(int amount) {
		balance = balance + amount;
	}

	public abstract void withdraw(int amount);
}
