package org.elsys.bank2;

public class CheckingAccount extends BankAccount {
	public CheckingAccount(int initial) {
		balance = initial;
	}

	@Override
	public void withdraw(int amount) {
		balance = balance - amount;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof CheckingAccount) {
			CheckingAccount account = (CheckingAccount) o;
			if (balance == account.balance) {
				return true;
			}
		}
		return false;
	}

}
