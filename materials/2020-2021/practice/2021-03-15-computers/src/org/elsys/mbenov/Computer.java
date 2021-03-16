package org.elsys.mbenov;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<IPart> parts;

    public Computer() {
        parts = new ArrayList<>();
    }

    public Computer(List<IPart> parts) {
        this.parts = parts;
    }

    public PowerData getConsumption() {
        PowerData result = new PowerData(0, 0, 0);

        for (IPart part : parts) {
            result = result.add(part.getConsumption());
        }

        return result;
    }


    public void addPart(IPart newPart) {
        if(newPart instanceof Motherboard) {
            for (IPart part : parts) {
                if(part instanceof Motherboard) throw new IllegalArgumentException("One motherboard is already present");
            }
        }

        if(newPart instanceof Processor) {
            int processorCount = 0;
            for (IPart part : parts) {
                if(part instanceof Processor && ++processorCount >= 2) throw new IllegalArgumentException("Two processors are already present");
            }
        }

        parts.add(newPart);
    }
}
