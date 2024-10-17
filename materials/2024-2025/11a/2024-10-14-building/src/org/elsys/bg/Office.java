package org.elsys.bg;

public class Office extends Building {

    @Override
    public double getPricePerMonth() {
        return 2000;
    }

    @Override
    public double estimateExpenses(int months) {
        return 200 * months;
    }
}
