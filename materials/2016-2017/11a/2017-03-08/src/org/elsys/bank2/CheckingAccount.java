package org.elsys.bank2;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(int initial) {
		super(initial);
	}

	@Override
	public void withdraw(int amount) {
		balance = balance - amount;
	}

}
