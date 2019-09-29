package org.elsys.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		List<Name> l = new ArrayList<Name>();
		List<Name> ll = new LinkedList<Name>();
		
		l.add(new Name("ivan", "ivanov"));
		l.add(new Name("peshso", "peshev"));
		System.out.println("list: " + l);
		
		l.add(0, new Name("kyncho", "kynev"));
		System.out.println("list: " + l);
	}

}
