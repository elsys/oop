package org.elsys.gates;

public class InverterGate extends Gate {
    private Wire input;
    private Wire output;

    public InverterGate(Wire input, Wire output) {
        this.input = input;
        this.output = output;

        addInput(input);
        addOutput(output);
    }

    @Override
    public void act() {
        output.setSignal(!input.getSignal());
    }
}
