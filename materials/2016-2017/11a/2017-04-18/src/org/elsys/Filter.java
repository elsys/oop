package org.elsys;

@FunctionalInterface
public interface Filter {

	boolean matches(Person person);
}
