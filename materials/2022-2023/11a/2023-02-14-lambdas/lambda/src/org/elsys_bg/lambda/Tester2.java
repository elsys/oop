package org.elsys_bg.lambda;

public class Tester2 implements Tester{
    @Override
    public boolean test(Person p) {
        return 20 < p.getAge() && p.getAge() < 30;
    }
}
