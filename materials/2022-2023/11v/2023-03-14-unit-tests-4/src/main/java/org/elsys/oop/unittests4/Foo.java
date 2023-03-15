package org.elsys.oop.unittests4;

import java.io.PrintStream;

public class Foo {
    private PrintStream os;

    public Foo(PrintStream os) {
        this.os = os;
    }

    public int bar(int a) {
        os.println(a);

        return a * 2;
    }
}
