package org.elsys.gates;

public abstract class NandFactory {
    public static Gate makeNotGate(Wire in, Wire out) {
        NandGate notGate = new NandGate(in, in, out);
        return notGate;
    }

    public static Gate makeXorGate(Wire in1, Wire in2, Wire out) {
        Wire out1 = new Wire();
        Wire out2 = new Wire();
        Wire out3 = new Wire();
        NandGate nandGate1 = new NandGate(in1, in2, out1);

        NandGate nandGate2 = new NandGate(in1, out1, out2);
        NandGate nandGate3 = new NandGate(in2, out1, out3);

        NandGate result = new NandGate(out2, out3, out);

        return result;
    }

    public static Gate makeAndGate(Wire in1, Wire in2, Wire out) {
        Wire out1 = new Wire();
        NandGate andGate1 = new NandGate(in1, in2, out1);
        NandGate andGate2 = new NandGate(out1, out1, out);
        return andGate2;
    }

    public static Gate makeOrGate(Wire in1, Wire in2, Wire out) {
        /*Wire outA = new Wire();
        Wire outB = new Wire();

        NandGate nandGateA = new NandGate(in1, in1, outA);
        NandGate nandGateB = new NandGate(in2, in2, outB);

        NandGate nandGateResult
                = new NandGate(outA, outB, out);

        return nandGateResult;
        /*CompositeGate gate1 = new CompositeGate();

        Wire outA = new Wire();
        Wire outB = new Wire();

        gate1.addInput(outA);
        gate1.addInput(outB);
        gate1.addInput(in1);
        gate1.addInput(in2);
        gate1.addOutput(out);
        gate1.addOutput(outA);
        gate1.addOutput(outB);

        NandGate andGateA = new NandGate(in1, in1, outA);
        NandGate andGateB = new NandGate(in2, in2, outB);

        NandGate result = new NandGate(outA, outB, out);

        gate1.addGate(andGateA);
        gate1.addGate(andGateB);
        gate1.addGate(result);

        return gate1;*/
        Wire outA = new Wire();
        Wire outB = new Wire();

        NandGate nandGateA = new NandGate(in1, in1, outA);
        NandGate nandGateB = new NandGate(in2, in2, outB);

        NandGate nandGateResult
                = new NandGate(outA, outB, out);

        return nandGateResult;
    }
}
