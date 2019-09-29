package org.elsys.bank2;

public class SavingsAccount extends BankAccount {
	private int numberOfWithdraws;

	public SavingsAccount(int initial) {
		balance = initial;
		numberOfWithdraws = 0;
	}

	@Override
	public void withdraw(int amount) {
		if (numberOfWithdraws > 5) {
			throw new RuntimeException("Cannot withdraw more than 5 times in a mount");
		}
		balance = balance - amount;
	}

}
