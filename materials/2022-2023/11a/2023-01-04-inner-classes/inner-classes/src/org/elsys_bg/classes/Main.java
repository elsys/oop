package org.elsys_bg.classes;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;
import static org.elsys_bg.classes.Point.PointBuilder.aPoint;

public class Main {
    public static void main(String[] args) {


        OuterClass oc = new OuterClass();
        OuterClass.InnerClass in = oc.new InnerClass(5);
        OuterClass.StaticInnerClass sic = new OuterClass.StaticInnerClass();
        System.out.println("Hello world!");
        Point p1 = aPoint().withX(12).withY(64).build();
        Point p2 = aPoint().withX(12).withY(64).build();
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        if( isNull(in) ) {

        }
    }

    public static void test() {
        int c;
        c = 2;
        if(true) {
            class Test {
                public void print() {
                    System.out.println(c);
                }
            }
            Test t = new Test();
        }
    }
}