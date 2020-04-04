package org.elsys.duzunov;

import java.time.LocalDateTime;

public class SmartLamp extends SmartDeviceBase {
    public SmartLamp(String name,
                     double powerConsumption,
                     LocalDateTime installationDateTime) {
        super(name, powerConsumption, installationDateTime, DeviceType.LAMP);
    }
}
