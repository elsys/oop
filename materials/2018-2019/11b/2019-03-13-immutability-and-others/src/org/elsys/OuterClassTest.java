package org.elsys;

import org.junit.jupiter.api.Test;

public class OuterClassTest {

    @Test
    public void test() {
        OuterClass oc = new OuterClass();
        OuterClass.InnerClass ic = oc.new InnerClass();
        OuterClass.InnerStaticClass isc = new OuterClass.InnerStaticClass();
    }
}
