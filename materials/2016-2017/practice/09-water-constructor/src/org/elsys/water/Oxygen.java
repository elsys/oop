package org.elsys.water;

public class Oxygen extends Atom implements Runnable {

	public Oxygen(int atomId, WaterConstructor constructor) {
		super(atomId, constructor);
	}

	@Override
	public void run() {
		System.out.println(this + " created");
		try {
			getConstructor().proceedOxygen(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Water molecule created with " + this);
	}

	@Override
	public String getFullName() {
		return "Oxygen";
	}
}
