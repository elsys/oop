package org.elsys.duzunov;

import java.time.LocalDateTime;
import java.util.HashMap;

public abstract class SmartDeviceBase implements SmartDevice {
    private static HashMap<DeviceType, Long> uniqueNumbers = new HashMap<>();
    static {
        for (var deviceType : DeviceType.values()) {
            uniqueNumbers.put(deviceType, 0L);
        }
    }

    private String name;
    private double powerConsumption;
    private LocalDateTime installationDateTime;
    private DeviceType type;
    private String id;

    public SmartDeviceBase(String name,
                           double powerConsumption,
                           LocalDateTime installationDateTime,
                           DeviceType type) {
        this.name = name;
        this.powerConsumption = powerConsumption;
        this.installationDateTime = installationDateTime;
        this.type = type;
        var uniqueNumber = uniqueNumbers.get(getType());
        id = String.format(
                "%s-%s-%d",
                getType().getShortName(),
                getName(),
                uniqueNumber
        );
        uniqueNumbers.put(getType(), uniqueNumber + 1);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPowerConsumption() {
        return powerConsumption;
    }

    @Override
    public LocalDateTime getInstallationDateTime() {
        return installationDateTime;
    }

    @Override
    public DeviceType getType() {
        return type;
    }
}
