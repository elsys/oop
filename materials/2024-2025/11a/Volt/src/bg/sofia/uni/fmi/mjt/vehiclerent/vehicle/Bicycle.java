package bg.sofia.uni.fmi.mjt.vehiclerent.vehicle;

import bg.sofia.uni.fmi.mjt.vehiclerent.exception.InvalidRentingPeriodException;

import java.time.Duration;
import java.time.LocalDateTime;

public class Bicycle extends Vehicle {

    private double pricePerDay;
    private double pricePerHour;

    public Bicycle(String id, String model, double pricePerDay, double pricePerHour) {
        super(id, model);
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
    }

    @Override
    public double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent) throws InvalidRentingPeriodException {
        Duration duration = Duration.between(startOfRent, endOfRent);
        long days = duration.toDays();
        if (days >= 7) {
            throw new InvalidRentingPeriodException("Bicycles can be rented for up to a week");
        }
        long hours = duration.toHours() % 24 + 1;
        return days * pricePerDay + hours * pricePerHour;
    }
}
