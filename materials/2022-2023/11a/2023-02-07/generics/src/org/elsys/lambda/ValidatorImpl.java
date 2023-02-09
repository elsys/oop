package org.elsys.lambda;

public class ValidatorImpl implements Validator{
    @Override
    public boolean test(String value) {
        return value.length() > 2;
    }
}
