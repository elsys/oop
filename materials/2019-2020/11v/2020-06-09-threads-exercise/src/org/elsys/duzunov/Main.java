package org.elsys.duzunov;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        SingleCashDesk singleCashDesk = new SingleCashDesk();

        Vault vault = new Vault(singleCashDesk);
        vault.start();

        Customer[] customers = createCustomers(100, singleCashDesk);
        serveCustomers(customers);

        System.out.println(
                Arrays.stream(customers)
                        .mapToDouble(Customer::getTotalPrice)
                        .sum()
        );
        System.out.println(singleCashDesk.getAmount() + vault.getAmount());
    }

    private static Customer[] createCustomers(int n, CashDesk cashDesk) {
        Customer[] customers = new Customer[n];
        for (int i = 0; i < customers.length; ++i) {
            customers[i] = new Customer(cashDesk, 10, 5);
        }
        return customers;
    }

    private static void serveCustomers(Customer[] customers) {
        ExecutorService fixedThreadPool =
                Executors.newFixedThreadPool(100);

        Arrays.stream(customers)
                .forEach(fixedThreadPool::submit);

        fixedThreadPool.shutdown();

        int maxServiceTime = Arrays.stream(customers)
                .mapToInt(Customer::getServiceTime)
                .max()
                .orElse(0);
        final int TIME_BUFFER = 5000;

        while (!fixedThreadPool.isTerminated()) {
            try {
                fixedThreadPool.awaitTermination(
                        maxServiceTime * customers.length + TIME_BUFFER,
                        TimeUnit.MILLISECONDS
                );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
