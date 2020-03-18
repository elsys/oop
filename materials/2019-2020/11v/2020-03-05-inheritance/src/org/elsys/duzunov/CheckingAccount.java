package org.elsys.duzunov;

public class CheckingAccount extends BankAccount {
    public CheckingAccount() {
        super();
    }

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CheckingAccount) {
            return this.balance == ((CheckingAccount) obj).balance;
        }

        return false;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }
}
