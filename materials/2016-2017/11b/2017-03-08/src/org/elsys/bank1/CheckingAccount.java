package org.elsys.bank1;

public class CheckingAccount implements BankAccount {
	private int balance;

	public CheckingAccount(int initial) {
		this.balance = initial;
	}

	public int getBalance() {
		return balance;
	}

	@Override
	public void withdraw(int amount) {
		balance = balance - amount;
	}

	@Override
	public void deposit(int amount) {
		balance = balance + amount;
	}

}
