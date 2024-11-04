package bg.sofia.uni.fmi.mjt.vehiclerent.exception;

public class VehicleAlreadyRentedException extends Exception {
    public VehicleAlreadyRentedException(String message) {
        super(message);
    }
}
