package org.elsys.gates;

public abstract class GateFactory {

	public static Gate makeXor(Wire in1, Wire in2, Wire out) {
		CompositeGate gate = new CompositeGate();
		gate.addInput(in1);
		gate.addInput(in2);
		gate.addOutput(out);
		
		Wire a = new Wire();
		Wire b = new Wire();
		Wire c = new Wire();
		
		Gate orGate = new OrGate(in1, in2, a);
		Gate andGate = new AndGate(in1, in2, b);
		Gate notGate = new InverterGate(b, c);
		Gate andGate1 = new AndGate(a,c, out);

		gate.addGate(orGate);
		gate.addGate(andGate);
		gate.addGate(notGate);
		gate.addGate(andGate1);
		
		return andGate;
	}


	public static Gate makeHalfAdder(Wire a, Wire b, Wire s, Wire c) {
		CompositeGate gate = new CompositeGate();

		gate.addInput(a);
		gate.addInput(b);
		gate.addOutput(s);
		gate.addOutput(c);

		Gate xorGate = new XorGate(a, b, s);
		Gate andGate = new AndGate(a, b, c);

		gate.addGate(xorGate);
		gate.addGate(andGate);

		return gate;
	}

	public static Gate makeRippleCarryAdder(Wire[] a, Wire[] b, Wire cIn, Wire[] sum, Wire cOut) {
		return new NandGate(a[0], b[0], cOut);
	}

	public static Gate makeFullAdder(Wire a, Wire b, Wire cIn, Wire sum, Wire cOut) {
		CompositeGate gate = new CompositeGate();
		gate.addInput(a);
		gate.addInput(b);
		gate.addInput(cIn);

		gate.addOutput(cOut);
		gate.addOutput(sum);

		Wire adderOut = new Wire();
		Wire adderC = new Wire();
		Gate halfAdder1
				= GateFactory.makeHalfAdder(a, b, adderOut, adderC);

		Wire adder2C = new Wire();
		Gate halfAdder2
				= GateFactory.
				makeHalfAdder(adderOut, cIn, sum, adder2C);

		OrGate orGate
				= new OrGate(adderC, adder2C, cOut);

		gate.addGate(halfAdder1);
		gate.addGate(halfAdder2);
		gate.addGate(orGate);

		return gate;
	}

}
