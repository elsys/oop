package org.elsys.mbenov;

public class Motherboard implements IPart {
    public final String chipset;

    public Motherboard(String chipset) {
        if(chipset.length() <= 0) throw new IllegalArgumentException("Chipset cannot be empty");

        this.chipset = chipset;
    }

    @Override
    public PowerData getConsumption() {
        double typical = switch (chipset) {
            case "am1" -> 25;
            case "am2" -> 35;
            case "am3" -> 50;
            default -> 30;
        };

        return new PowerData(
                typical,
                typical,
                typical
        );
    }
}
