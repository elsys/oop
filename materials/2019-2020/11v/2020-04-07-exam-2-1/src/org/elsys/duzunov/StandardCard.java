package org.elsys.duzunov;

public class StandardCard extends Card {
    public StandardCard(String name) {
        super(name);
    }

    @Override
    public boolean executePayment(double cost) {
        if (cost < 0 || getAmount() < cost) {
            return false;
        }

        setAmount(getAmount() - cost);
        return true;
    }
}
