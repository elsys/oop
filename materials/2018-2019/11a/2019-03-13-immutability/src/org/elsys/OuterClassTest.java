package org.elsys;

import org.junit.jupiter.api.Test;

public class OuterClassTest {

    @Test
    public void test() {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        OuterClass.InnerStaticClass innerStaticClass =
                new OuterClass.InnerStaticClass();
    }
}
