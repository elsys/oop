package org.elsys.mbenov;

public class Mule extends Mafiot implements ICarrier {
    String stock = "";

    @Deprecated
    public Mule(double income, String nickname, String stock) {
        super(income, nickname);
        this.stock = stock;
    }

    @Override
    public void carry() {
        System.out.println(nickname + " am a mule and I carry " + stock);
    }
}
