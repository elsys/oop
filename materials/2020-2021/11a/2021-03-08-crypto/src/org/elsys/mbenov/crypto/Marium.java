package org.elsys.mbenov.crypto;

import java.util.Random;

public class Marium extends Crpytocurrency {
    private Random rand;

    public Marium(double startingPrice, Random rand) {
        super(startingPrice, "Marium");
        this.rand = rand;
    }

    @Override
    public void updatePrice(double sold, double bought) {
        price -= sold * rand.nextDouble();
        price += bought * rand.nextDouble();
    }
}
