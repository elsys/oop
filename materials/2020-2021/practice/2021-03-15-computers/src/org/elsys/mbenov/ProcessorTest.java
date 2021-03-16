package org.elsys.mbenov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorTest {
    @Test
    void constructorThrows() {
        assertDoesNotThrow(() -> new Processor(4, 2.3));

        assertThrows(IllegalArgumentException.class, () -> new Processor(-4, 2.3));
        assertThrows(IllegalArgumentException.class, () -> new Processor(4, -2.3));
    }

    @Test
    void getConsumptionCorrectValues() {
        Processor instance = new Processor(1, 2);
        PowerData data = instance.getConsumption();
        assertArrayEquals(new double[] {0.25, 1.0, 5.0}, new double[] {data.minimumPower, data.typicalPower, data.maximumPower});

        instance = new Processor(4, 2);
        data = instance.getConsumption();
        assertArrayEquals(new double[] {1.0, 4.0, 20.0}, new double[] {data.minimumPower, data.typicalPower, data.maximumPower});

        instance = new Processor(1, 4.5);
        data = instance.getConsumption();
        assertArrayEquals(new double[] {1.26, 5.06, 25.31}, new double[] {data.minimumPower, data.typicalPower, data.maximumPower}, 0.01);
    }
}