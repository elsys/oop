package org.elsys_bg.lambda;

public class AgeRangePersonFilter implements PersonFilter{
    @Override
    public boolean test(Person p) {
        if(p.getAge() >= 18 && p.getAge() <= 25) {
            return true;
        }

        return false;
    }
}
