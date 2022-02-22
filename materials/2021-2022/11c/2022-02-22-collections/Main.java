package com.company;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        int dayOfMonth = now.getDayOfMonth();

        String format = "";
        switch (dayOfMonth) {
            case 1: format = "st"; break;
            case 2: format = "nd"; break;
            case 3: format = "rd"; break;
            default: format = "th"; break;
        }

        System.out.println("Today is " + dayOfMonth + format);

        CollectionsDemo demo = new CollectionsDemo(dayOfMonth);

        demo.generateRandomNumber();

        demo.arrayDemo();
        demo.arrayList_Demo();
        demo.linkedList_Demo();
        demo.vector_Demo();
        demo.hashSet_Demo();
        demo.hashMap_Demo();
        demo.stack_Demo();

    }
}
