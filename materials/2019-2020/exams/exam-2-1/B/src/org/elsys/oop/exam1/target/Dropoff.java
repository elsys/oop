package org.elsys.oop.exam1.target;

import org.elsys.oop.exam1.Point;

public class Dropoff extends BaseTarget {
    private int totalResource;

    public Dropoff(Point pos, int totalResource) {
        super(pos);
        this.totalResource = totalResource;
    }

    public int getTotalResource() {
        return totalResource;
    }

    public void add(int delta) {
        totalResource += delta;
        System.out.println("[" + pos + "] Added " + delta + " and now have " + totalResource);
    }

    @Override
    public String toString() {
        return "Dropoff{" +
                "totalResource=" + totalResource +
                ", pos=" + pos +
                '}';
    }
}
