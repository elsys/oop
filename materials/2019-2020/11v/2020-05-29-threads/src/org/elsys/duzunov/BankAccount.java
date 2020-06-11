package org.elsys.duzunov;

public class BankAccount {
    private static int operationsCount;

    private double balance;

    public BankAccount() {
        balance = 0;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized void withdraw(double amount) {
        balance -= amount;
    }

    public synchronized double getBalance() {
        return balance;
    }

    // Бъг - този метод също трябва да е синхронизиран
    public void verifyAndWithdraw(double amount) {
        // balance == 100 && amount == 90
        if (getBalance() >= amount) {
            // thread1
            // thread2 - amount == 20
            // thread1
            withdraw(amount);
            // thread2 - balance == 80
            // thread1 - balance == -10
        }
    }

    public static void incrementOperationsCount() {
        synchronized (BankAccount.class) { // в контекста на инстация момем да я
            // достъпим с this: this.getClass()
            ++operationsCount;
        }
    }

    public static synchronized void incrementOperationsCountSynchronized() {
        ++operationsCount;
    }
}
