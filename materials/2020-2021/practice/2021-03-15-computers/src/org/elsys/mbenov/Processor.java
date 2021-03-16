package org.elsys.mbenov;

public class Processor implements IPart {
    public final int cores;
    public final double frequency;

    public Processor(int cores, double frequency) {
        if(cores <= 0) throw new IllegalArgumentException("Cores cannot be negative");
        if(frequency <= 0) throw new IllegalArgumentException("Frequency cannot be negative");

        this.cores = cores;
        this.frequency = frequency;
    }

    @Override
    public PowerData getConsumption() {
        double typical = cores * (Math.pow(frequency, 2) / 2) * 0.5;
        return new PowerData(
                typical * 0.25,
                typical,
                typical * 5
        );
    }
}
