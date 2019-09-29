package org.elsys.bank2;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(int initial) {
		super(initial);
	}

	@Override
	public void withdraw(int amount) {
		balance = balance - amount;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof CheckingAccount) {
			CheckingAccount a = (CheckingAccount) o;
			if (balance == a.balance) {
				return true;
			}
		}

		return false;
	}
}
