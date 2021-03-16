package org.elsys.mbenov;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MotherboardTest {
    @Test
    void constructorThrows() {
        assertDoesNotThrow(() -> new Motherboard("am1"));
        assertThrows(IllegalArgumentException.class, () -> new Motherboard(""));
    }

    @Test
    void getConsumptionCorrectValues() {
        Motherboard instance = new Motherboard("am1");
        PowerData data = instance.getConsumption();

        assertEquals(25.0, data.minimumPower);
        assertEquals(25.0, data.typicalPower);
        assertEquals(25.0, data.maximumPower);

        instance = new Motherboard("am2");
        data = instance.getConsumption();
        assertArrayEquals(new double[] {35.0, 35.0, 35.0}, new double[] {data.minimumPower, data.typicalPower, data.maximumPower});

        instance = new Motherboard("am3");
        data = instance.getConsumption();
        assertArrayEquals(new double[] {50.0, 50.0, 50.0}, new double[] {data.minimumPower, data.typicalPower, data.maximumPower});

        instance = new Motherboard("other");
        data = instance.getConsumption();
        assertArrayEquals(new double[] {30.0, 30.0, 30.0}, new double[] {data.minimumPower, data.typicalPower, data.maximumPower});
    }
}