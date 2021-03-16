package org.elsys.mbenov;

public class PowerData {
    public final double minimumPower;
    public final double typicalPower;
    public final double maximumPower;

    public PowerData(double minimumPower, double typicalPower, double maximumPower) {
        this.minimumPower = minimumPower;
        this.typicalPower = typicalPower;
        this.maximumPower = maximumPower;
    }

    public PowerData add(PowerData other) {
        return new PowerData(
                minimumPower + other.minimumPower,
                typicalPower + other.typicalPower,
                maximumPower + other.maximumPower
        );
    }
}
