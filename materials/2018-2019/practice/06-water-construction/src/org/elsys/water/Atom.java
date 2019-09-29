package org.elsys.water;

public abstract class Atom {

	private final WaterConstructor constructor;

	private final int atomId;

	public Atom(int atomId, WaterConstructor constructor) {
		this.constructor = constructor;
		this.atomId = atomId;
	}

	public WaterConstructor getConstructor() {
		return constructor;
	}

	public int getAtomId() {
		return atomId;
	}

	public void bond() {
		System.out.println(this + " bonded");
	}
	
	@Override
	public String toString() {
		return getFullName() + "-" + atomId;
	}

	public abstract String getFullName();
}
