package org.elsys.bank2;

public class SavingsAccount extends BankAccount {

	private int numberOfWithdrawals;

	public SavingsAccount(int initial) {
		super(initial);
		numberOfWithdrawals = 0;
	}

	@Override
	public void withdraw(int amount) {
		if (numberOfWithdrawals >= 4) {
			throw new RuntimeException();
		}
		numberOfWithdrawals += 1;
		balance -= amount;
	}

	public void resetNumberOfWithdrawals() {
		numberOfWithdrawals = 0;
	}
}
