package org.elsys.duzunov;

public class GoldenCard extends Card {
    public GoldenCard(String name) {
        super(name);
    }

    @Override
    public boolean executePayment(double cost) {
        if (cost < 0 || getAmount() < cost) {
            return false;
        }

        setAmount(getAmount() - .85 * cost);
        return true;
    }
}
