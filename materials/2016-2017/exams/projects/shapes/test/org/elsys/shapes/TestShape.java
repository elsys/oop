package org.elsys.shapes;

public class TestShape implements Shape {

	private double area;
	
	public TestShape(double area) {
		this.area = area;
	}
	
	@Override
	public void draw() {
		System.out.println("TestShape with constant area: " + area);
	}

	@Override
	public double calculateArea() {
		return area;
	}

}
