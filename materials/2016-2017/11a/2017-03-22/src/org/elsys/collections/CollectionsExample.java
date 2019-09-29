package org.elsys.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsExample {

	public static void main(String[] args) {
		Collection<Name> col = new LinkedList<Name>();

		col.add(new Name("a", "a"));
		col.add(new Name("b", "b"));

		System.out.println("size: " + col.size());
		System.out.println("col: " + col);

		col.remove(new Name("a", "a"));
		System.out.println("col: " + col);

		Collection<Name> col2 = new LinkedList<Name>();
		col2.add(new Name("c", "c"));
		col2.add(new Name("d", "d"));

		col.addAll(col2);
		System.out.println("col: " + col);

		Iterator<Name> it = col.iterator();
		while (it.hasNext()) {
			Name name = it.next();
			System.out.println("name: " + name);
		}

		for(Name name: col) {
			System.out.println("name from for: " + name);
		}
		
		it = col.iterator();
		while(it.hasNext()) {
			Name name = it.next();
			if(name.getFirstName().equals("c")) {
				it.remove();
			}
		}
		System.out.println("col after remove: " + col);
		
	}

}
