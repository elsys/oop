package org.elsys.gates;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InverterGateTest {
    private Wire input;
    private Wire out;
    private Gate gate;

    @Before
    public void setup(){
        input = new Wire();
        out = new Wire();

        gate = new InverterGate(input, out);
    }

    @Test
    public void testInTrue(){
        input.setSignal(true);

        assertFalse(out.getSignal());
    }

    @Test
    public void testInFalse(){
        input.setSignal(false);

        assertTrue(out.getSignal());
    }
}
