package org.elsys.mbenov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HardDriveTest {
    @Test
    void constructorThrows() {
        assertDoesNotThrow(() -> new HardDrive(4000, 16));

        assertThrows(IllegalArgumentException.class, () -> new HardDrive(-4000, 16));
        assertThrows(IllegalArgumentException.class, () -> new HardDrive(4000, -16));
    }

    @Test
    void getConsumptionCorrectValues() {
        HardDrive instance = new HardDrive(4000, 16);
        PowerData data = instance.getConsumption();
        assertArrayEquals(new double[] {0.04, 0.4, 0.8}, new double[] {data.minimumPower, data.typicalPower, data.maximumPower}, 0.01);

        instance = new HardDrive(8000, 16);
        data = instance.getConsumption();
        assertArrayEquals(new double[] {0.08, 0.8, 1.6}, new double[] {data.minimumPower, data.typicalPower, data.maximumPower}, 0.01);

        instance = new HardDrive(4000, 32);
        data = instance.getConsumption();
        assertArrayEquals(new double[] {0.08, 0.8, 1.6}, new double[] {data.minimumPower, data.typicalPower, data.maximumPower}, 0.01);
    }
}