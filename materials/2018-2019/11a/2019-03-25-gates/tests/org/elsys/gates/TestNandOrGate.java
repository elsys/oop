package org.elsys.gates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.SQLOutput;

public class TestNandOrGate {

	private Wire in1;
	private Wire in2;
	private Wire out;

	private Gate orGate;

	@Before
	public void beforeEach() {
		in1 = new Wire();
		in2 = new Wire();

		out = new Wire();
		orGate = NandFactory.makeOrGate(in1, in2, out);
		assertNotNull(orGate);
	}

	@Test
	public void testIn1FalseIn2False() {
		System.out.println(in1.getSignal());
		assertFalse(in1.getSignal());
		assertFalse(in2.getSignal());
		assertFalse(out.getSignal());
	}

	@Test
	public void outIn1TrueIn2False() {
		in1.setSignal(true);
		assertTrue(out.getSignal());
	}

	@Test
	public void outIn1FalseIn2True() {
		in2.setSignal(true);
		assertTrue(out.getSignal());
	}

	@Test
	public void outIn1TrueIn2True() throws InterruptedException {
		in1.setSignal(true);
		in2.setSignal(true);
		assertTrue(out.getSignal());
	}
}