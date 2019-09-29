package org.elsys.collections;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		Set<Name> s = new HashSet<Name>();
		Name n1 = new Name("a", "a");
		Name n2 = new Name("b", "b");

		s.add(n1);
		s.add(n2);

		System.out.println("check n1: " + s.contains(n1));
		System.out.println("set: " + s);

		n1.lastName = "c";
		System.out.println("set: " + s);

		System.out.println("check n1: " + s.contains(n1));

	}

}
