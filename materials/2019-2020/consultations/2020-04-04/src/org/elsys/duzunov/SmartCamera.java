package org.elsys.duzunov;

import java.time.LocalDateTime;

public class SmartCamera extends SmartDeviceBase {
    public SmartCamera(String name,
                       double powerConsumption,
                       LocalDateTime installationDateTime) {
        super(name, powerConsumption, installationDateTime, DeviceType.CAMERA);
    }
}
