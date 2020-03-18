package org.elsys.duzunov;

public class Main {
    private static void withdraw(IBankAccount bankAccount, double amount) {
        bankAccount.withdraw(amount);
    }

    public static void main(String[] args) {
        Person p = new Person("Ivan", 18);
        System.out.println(p.getName());
        System.out.println(p.getAge());

        Employee e = new Employee("Petar", 21, 3000);
        System.out.println(e.getName());
        System.out.println(e.getAge());
        System.out.println(e.getSalary());

        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.deposit(1000);
        checkingAccount.deposit(300);
        withdraw(checkingAccount, 20);
        withdraw(checkingAccount, 20);
        withdraw(checkingAccount, 20);
        withdraw(checkingAccount, 20);
        withdraw(checkingAccount, 20);
        withdraw(checkingAccount, 20);
        System.out.println(checkingAccount.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount(1000);
        withdraw(savingsAccount, 20);
        withdraw(savingsAccount, 20);
        withdraw(savingsAccount, 50);
        withdraw(savingsAccount, 20);
        withdraw(savingsAccount, 30);

        try {
            withdraw(savingsAccount, 20);
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException.getMessage());
        }
        System.out.println(savingsAccount.getBalance());

        SavingsAccount sa1 = new SavingsAccount();
        SavingsAccount sa2 = new SavingsAccount();
        System.out.println(sa1.equals(sa2));

        Object ca1 = new CheckingAccount();
        Object ca2 = new CheckingAccount();
        System.out.println(ca1.equals(ca2));
    }
}
