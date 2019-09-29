package org.elsys.gates;

import java.util.ArrayList;
import java.util.List;

public abstract class Gate {

    private List<Wire> inputs
            = new ArrayList<Wire>();
    private List<Wire> outputs
            = new ArrayList<Wire>();

    public abstract void act();

    public void addInput(Wire wire){
        if(!inputs.contains(wire)){
            inputs.add(wire);
            wire.connect(this);
        }
    }

    public void addOutput(Wire wire){
        if (!outputs.contains(wire)){
            outputs.add(wire);
        }
    }
}
