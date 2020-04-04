package org.elsys.duzunov;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class SmartCityHub {
    public static class DeviceAlreadyRegisteredException extends Exception {}

    public static class DeviceNotFoundException extends Exception {}

    private static class PowerConsumptionComparator
            implements Comparator<SmartDevice> {
        @Override
        public int compare(SmartDevice o1, SmartDevice o2) {
            return -Double.compare(powerConsumption(o1), powerConsumption(o2));
        }

        private double powerConsumption(SmartDevice smartDevice) {
            long hoursWorked = Duration.between(
                    smartDevice.getInstallationDateTime(),
                    LocalDateTime.now()
            ).toHours();
            return hoursWorked * smartDevice.getPowerConsumption();
        }
    }

    private HashMap<String, SmartDevice> devices = new HashMap<>();
    private HashMap<DeviceType, Integer> devicesCount = new HashMap<>();
    private TreeSet<SmartDevice> devicesByPowerConsumption =
            new TreeSet<>(new PowerConsumptionComparator());

    public SmartCityHub() {
        for (var deviceType : DeviceType.values()) {
            devicesCount.put(deviceType, 0);
        }
    }

    /**
     * Adds a @device to the SmartCityHub.
     *
     * @throws IllegalArgumentException in case @device is null.
     * @throws DeviceAlreadyRegisteredException in case the @device is already registered.
     */
    public void register(SmartDevice device)
            throws DeviceAlreadyRegisteredException {
        if (device == null) {
            throw new IllegalArgumentException();
        }

        if (devices.containsKey(device.getId())) {
            throw new DeviceAlreadyRegisteredException();
        }

        devices.put(device.getId(), device);

        var deviceType = device.getType();
        devicesCount.put(deviceType, devicesCount.get(deviceType) + 1);

        devicesByPowerConsumption.add(device);
    }

    /**
     * Removes the @device from the SmartCityHub.
     *
     * @throws IllegalArgumentException in case null is passed.
     * @throws DeviceNotFoundException in case the @device is not found.
     */
    public void unregister(SmartDevice device) throws DeviceNotFoundException {
        if (device == null) {
            throw new IllegalArgumentException();
        }

        var value = devices.remove(device.getId());
        if (value == null) {
            throw new DeviceNotFoundException();
        }

        var deviceType = device.getType();
        devicesCount.put(deviceType, devicesCount.get(deviceType) - 1);

        devicesByPowerConsumption.remove(device);
    }

    /**
     * Returns a SmartDevice with an ID @id.
     *
     * @throws IllegalArgumentException in case @id is null.
     * @throws DeviceNotFoundException in case device with ID @id is not found.
     */
    public SmartDevice getDeviceById(String id) throws DeviceNotFoundException {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        var value = devices.get(id);
        if (value == null) {
            throw new DeviceNotFoundException();
        }
        return value;
    }

    /**
     * Returns the total number of devices with type @type registered in SmartCityHub.
     *
     * @throws IllegalArgumentException in case @type is null.
     */
    public int getDeviceQuantityPerType(DeviceType type) {
        if (type == null) {
            throw new IllegalArgumentException();
        }

        return devicesCount.get(type);
    }

    /**
     * Returns a collection of IDs of the top @n devices which consumed
     * the most power from the time of their installation until now.
     *
     * The total power consumption of a device is calculated by the hours elapsed
     * between the two LocalDateTime-s: the installation time and the current time (now)
     * multiplied by the stated nominal hourly power consumption of the device.
     *
     * If @n exceeds the total number of devices, return all devices available sorted by the given criterion.
     * @throws IllegalArgumentException in case @n is a negative number.
     */
    public Collection<String> getTopNDevicesByPowerConsumption(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        // Този код върши работа, но е бавен, тъй като трябва да минем през
        // всички регистрирани устройства и да ги сортираме.
        // var devicesList = new ArrayList<>(devices.values());
        // devicesList.sort(new PowerConsumptionComparator());
        // var ids = new ArrayList<String>();
        // for (int i = 0; i < n; ++i) {
        //     ids.add(devicesList.get(i).getId());
        // }
        // return ids;

        // Използваме TreeSet, за да не се налага да сортираме - TreeSet
        // структурата от данни поддържа елементите сортирани. Нужно е
        // единствено да вземем първите n елемента.
        n = Math.min(n, devicesByPowerConsumption.size());
        var ids = new ArrayList<String>();
        var devicesIterator = devicesByPowerConsumption.iterator();
        for (int i = 0; i < n; ++i) {
            ids.add(devicesIterator.next().getId());
        }
        return ids;
    }

    /**
     * Returns a collection of the first @n registered devices, i.e the first @n that were added
     * in the SmartCityHub (registration != installation).
     *
     * If @n exceeds the total number of devices, return all devices available sorted by the given criterion.
     *
     * @throws IllegalArgumentException in case @n is a negative number.
     */
    public Collection<SmartDevice> getFirstNDevicesByRegistration(int n) {
        throw new UnsupportedOperationException();
    }
}
