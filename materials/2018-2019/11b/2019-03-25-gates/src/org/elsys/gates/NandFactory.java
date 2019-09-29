package org.elsys.gates;

public abstract class NandFactory {
    public static Gate makeNotGate(Wire in, Wire out) {
	    NandGate gate = new NandGate(in, in, out);
	    return gate;
    }

    public static Gate makeOrGate(Wire in1, Wire in2, Wire out) {
        Wire outA = new Wire();
        Wire outB = new Wire();

        NandGate nandGateA = new NandGate(in1, in1, outA);
        NandGate nandGateB = new NandGate(in2, in2, outB);

        NandGate nandGateResult
                = new NandGate(outA, outB, out);

        return nandGateResult;
    }

    public static Gate makeAndGate(Wire in1, Wire in2, Wire out) {
        Wire out1 = new Wire();
        NandGate nandGate1
                = new NandGate(in1, in2, out1);

        NandGate nandGateResult
                = new NandGate(out1, out1, out);

        return nandGateResult;
    }

    public static Gate makeXorGate(Wire in1, Wire in2, Wire out) {
        Wire a = new Wire();
        Wire b = new Wire();
        Wire c = new Wire();
        Wire d = new Wire();

        NandGate gate1 = new NandGate(in1, in2, a);
        NandGate gate2 = new NandGate(in1, a, c);
        NandGate gate3 = new NandGate(in2, a, d);

        NandGate gateResult = new NandGate(c, d, out);
        return gateResult;
    }
}
