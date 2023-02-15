package org.elsys_bg.lambda;

//Functional interface
//if only have one abstract method
public interface Tester {
    boolean test(Person p);

//    boolean test2(Person p2);
    default boolean test() {
        return true;
    }
}
