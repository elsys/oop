package org.elsys.duzunov;

public abstract class Card {
    private String name;
    private double amount;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    protected void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean feed(double amount) {
        if (amount < 0) {
            return false;
        }

        setAmount(amount);
        return true;
    }

    public abstract boolean executePayment(double cost);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return getName().equals(card.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
