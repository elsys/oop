package org.elsys.water;

public class Hydrogen extends Atom implements Runnable {

	public Hydrogen(int atomId, WaterConstructor constructor) {
		super(atomId, constructor);
	}

	@Override
	public void run() {
		System.out.println(this + " created");
		try {
			getConstructor().proceedHydrogen(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Water molecule created with " + this);
	}

	@Override
	public String getFullName() {
		return "Hydrogen";
	}
}
