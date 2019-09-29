package org.elsys.zoo;

public class TestAnimal implements Animal {

	@Override
	public double getFoodPerDay() {
		return 5;
	}

	@Override
	public String getName() {
		return "Test animal";
	}

	@Override
	public void act() {
		// test animal won't do a thing
	}

}
