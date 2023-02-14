package org.elsys_bg.lambda;

public class Tester1 implements Tester {
    @Override
    public boolean test(Person p) {
        return p.getAge() < 18;
    }
}
