package org.elsys.mbenov.crypto;

import java.util.Random;

public class Stelacoin extends Cryptocurrency {
    private Random rand;

    public Stelacoin(double basePrice, Random rand) {
        super("Stelacoin", basePrice);
        //super(Stelacoin.class.getTypeName(), basePrice);
        this.rand = rand;
    }

    @Override
    public void updatePrice(double sold, double bought) {
        price -= sold * rand.nextDouble();
        price += bought * rand.nextDouble();
    }
}
