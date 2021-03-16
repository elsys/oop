package org.elsys.mbenov;

public class HardDrive implements IPart {
    public final int speed;
    public final double capacity;

    public HardDrive(int speed, double capacity) {
        if(speed <= 0) throw new IllegalArgumentException("Speed cannot be negative");
        if(capacity <= 0) throw new IllegalArgumentException("Capacity cannot be negative");

        this.speed = speed;
        this.capacity = capacity;
    }

    @Override
    public PowerData getConsumption() {
        double typical = speed * capacity / 160000;
        return new PowerData(
                typical * 0.1,
                typical,
                typical * 2
        );
    }
}
