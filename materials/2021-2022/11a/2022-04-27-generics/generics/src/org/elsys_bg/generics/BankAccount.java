package org.elsys_bg.generics;

public enum BankAccount {
    DEBIT_ACCOUNT {
        @Override
        public void getBanckAccount() {
            "Debit" + "BankAccount"
        }
    },
    CREDIT_ACCOUNT;

    public abstract BankAccount getBanckAccount();
}
