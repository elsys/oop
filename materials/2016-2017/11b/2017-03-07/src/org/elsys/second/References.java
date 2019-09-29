package org.elsys.second;

public class References {

	public static void main(String[] args) {
		Student st = null;
		
		System.out.println(st);
		// System.out.println(st.getName());
		
		st = new Student();
		System.out.println(st.getName());
		System.out.println(st.getNumber());
		
		setDefaultName(st);
		System.out.println(st.getName());
		
		st.setNumber(NumberGenerator.nextNumber());
		System.out.println(st.getNumber());
		NumberGenerator gen = new NumberGenerator();
		System.out.println(gen.nextNumber()); // bad practice
		
	}
	
	private static void setDefaultName(Student student) {
		student.setName("Unknown");
	}

}
