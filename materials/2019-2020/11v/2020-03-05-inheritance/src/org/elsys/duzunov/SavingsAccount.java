package org.elsys.duzunov;

public class SavingsAccount extends BankAccount {
    private int withdraws;

    public SavingsAccount() {
        super();
        withdraws = 0;
    }

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
        withdraws = 0;
    }

    @Override
    public void withdraw(double amount) {
        if (withdraws < 5) {
            balance -= amount;
            withdraws++;
        } else {
            throw new RuntimeException(
                    "Cannot withdraw more than 5 times a month"
            );
        }
    }
}
