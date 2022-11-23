package org.elsys_bg.junit;

import org.junit.jupiter.api.BeforeEach;

public class AbstractTestClass {

    Calculator c;

    @BeforeEach
    void setUp() {
        c = new Calculator();
    }
}
