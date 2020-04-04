package org.elsys.duzunov;

import java.time.LocalDateTime;

public class SmartTrafficLight extends SmartDeviceBase {
    public SmartTrafficLight(String name,
                             double powerConsumption,
                             LocalDateTime installationDateTime) {
        super(
                name,
                powerConsumption,
                installationDateTime,
                DeviceType.TRAFFIC_LIGHT
        );
    }
}
