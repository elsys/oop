package org.elsys.duzunov;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        SmartTrafficLight stl1 = new SmartTrafficLight(
                "stl1",
                10,
                LocalDateTime.now()
        );
        System.out.println(stl1.getId());
        SmartTrafficLight stl2 = new SmartTrafficLight(
                "stl2",
                12,
                LocalDateTime.now()
        );
        System.out.println(stl2.getId());
        SmartCamera smartCamera = new SmartCamera(
                "smartCamera",
                12,
                LocalDateTime.now()
        );
        System.out.println(smartCamera.getId());
    }
}
