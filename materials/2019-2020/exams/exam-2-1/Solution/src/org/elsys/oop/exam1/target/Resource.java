package org.elsys.oop.exam1.target;

import org.elsys.oop.exam1.Point;

public class Resource extends BaseTarget {
    private int quantity;

    public Resource(Point pos, int quantity) {
        super(pos);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void subtract(int delta) {
        if(delta < 0 || delta > quantity) {
            throw new IllegalArgumentException("Resource delta cannot be negative or greater than the current quantity.");
        }

        quantity -= delta;
        System.out.println("[" + pos + "] Removed " + delta + " and left with " + quantity);
    }

    @Override
    public String toString() {
        return "Resource{" +
                "quantity=" + quantity +
                ", pos=" + pos +
                '}';
    }
}
