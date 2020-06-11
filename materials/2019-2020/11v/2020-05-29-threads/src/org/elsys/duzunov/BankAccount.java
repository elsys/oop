package org.elsys.duzunov;

public class BankAccount {
    private static int operationsCount;

    private double balance;

    public BankAccount() {
        balance = 0;
    }

    public synchronized void deposit(double amount) {
        // Нишка може да извести чакащи нишки, че дадено събитие се е случило
        // и те могат да продължат своето изпълнение. Това става чрез метода
        // notify() на java.lang.Object

        // При депозиране на пари по сметка, уведомяваме чакащите нишки,
        // че са постъпили средства по сметката
        this.notify();
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

    // Нишка може да заяви, че иска да изчака, докато дадено събитие се случи
    // в друга нишка, чрез метода wait() на java.lang.Object
    public synchronized void withdrawCreditPayment(double monthFee) {
        while (this.balance < monthFee) {
            try {
                // Изчакваме и освобождаваме монитора this
                this.wait();
            } catch (InterruptedException e) {
                // хвърля изключение, ако нишката бъде прекъсната
            }
        }
        balance -= monthFee;
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
