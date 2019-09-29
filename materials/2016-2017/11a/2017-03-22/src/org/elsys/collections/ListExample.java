package org.elsys.collections;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

	
	public static void main(String[] args) {
		List<Name> l = new ArrayList<Name>();
		
		l.add(new Name("a", "a"));
		l.add(0, new Name("b", "b"));
		
		System.out.println("list: " + l);
		
		System.out.println("get(0): " + l.get(0));
		System.out.println("get(1): " + l.get(1));
	
		System.out.println("indexOf: " + l.indexOf(new Name("a", "a")));
	}
}
