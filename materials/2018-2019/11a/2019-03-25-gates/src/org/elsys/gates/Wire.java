package org.elsys.gates;

import java.util.ArrayList;
import java.util.List;

public class Wire {
	private boolean state;
	List<Gate> gates;

	public Wire() {
		state = false;
		gates = new ArrayList<Gate>();
	}

	public boolean getSignal() {
		return state;
	}

	public void setSignal(boolean state) {
		this.state = state;
		for(Gate gate:gates){
			gate.act();
		}
	}

	public void connect(Gate gate){
		if (!gates.contains(gate)){
			gates.add(gate);
		}
	}

}