package org.elsys.second;

public class References {

	public static void main(String[] args) {
		Employee e = null;
		
		System.out.println(e);
		// System.out.println(e.getName());
		
		e = new Employee();
		System.out.println(e.getId());
		System.out.println(e.getName());
		System.out.println(e);

		// passing object by reference
		setDefaultName(e);
		System.out.println(e.getName());

		int i = 0, j = i;
		j = 15;
		System.out.println(i);
		
		e.setId(IdInitializer.nextId());
		System.out.println(e.getId());
		e.setId(IdInitializer.nextId());
		System.out.println(e.getId());

		IdInitializer init = new IdInitializer();
		System.out.println(init.nextId()); // bad practice
	}
	
	private static void setDefaultName(Employee e) {
		e.setName("Unidentified");
	}

}
