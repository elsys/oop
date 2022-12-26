package org.elsys.oop.packagesdemo;

import org.elsys.oop.packagesdemo.inner.*;

//import java.util.Date;
//import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        Demo d = new Demo();

        java.util.Date d1 = new java.util.Date();
        java.sql.Date d2 = new java.sql.Date(1234);


        System.out.println(d instanceof Demo);
        System.out.println(d.getClass().getName());
    }
}
