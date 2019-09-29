package org.elsys.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionExample {

	public static void main(String[] args) {
		Collection<Name> col = new ArrayList<Name>();
		Collection<Name> colset = new HashSet<Name>();
		
		col.add(new Name("pesho", "peshev"));
		col.add(new Name("ivan", "ivanov"));
		
		System.out.println("size: " + col.size());
		System.out.println("col: " + col);
		
		
		System.out.println("contains: " + col.contains(new Name("pesho", "peshev")));
		
		
		col.remove(new Name("pesho", "peshev"));
		System.out.println("size: " + col.size());
		System.out.println("col: " + col);
		
		
		Collection<Name> col2 = new ArrayList<Name>();
		col2.add(new Name("pesho", "peshev"));
		col2.add(new Name("pesho", "ivanov"));
		
		col.addAll(col2);
		System.out.println("size: " + col.size());
		System.out.println("col: " + col);
		
		Iterator<Name> it = col.iterator();
		while(it.hasNext()) {
			Name n = it.next();
			System.out.println("name: " + n);
		}
		
		for(Name n: col) {
			System.out.println("name: " + n);
		}
		
		it = col.iterator();
		while(it.hasNext()) {
			Name n = it.next();
			System.out.println("removing name: " + n);
			it.remove();
		}
		System.out.println("size: " + col.size());
		System.out.println("col: " + col);

	}

}
