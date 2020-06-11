package org.elsys.duzunov;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        SingleCashDesk singleCashDesk = new SingleCashDesk();
        Customer[] customers = createCustomers(100, singleCashDesk);
        serveCustomers(customers);
        System.out.println(
                Arrays.stream(customers)
                        .mapToDouble(Customer::getTotalPrice)
                        .sum()
        );
        System.out.println(singleCashDesk.getAmount());
    }

    private static Customer[] createCustomers(int n, CashDesk cashDesk) {
        Customer[] customers = new Customer[n];
        for (int i = 0; i < customers.length; ++i) {
            customers[i] = new Customer(cashDesk, 10, 1);
        }
        return customers;
    }

    private static void serveCustomers(Customer[] customers) {
        List<Thread> customerThreads = Arrays.stream(customers)
                .map(Thread::new)
                .collect(Collectors.toList());

        customerThreads.forEach(Thread::start);
        customerThreads.forEach(customerThread -> {
            try {
                customerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
