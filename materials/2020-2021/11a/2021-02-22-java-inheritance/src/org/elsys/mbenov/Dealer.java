package org.elsys.mbenov;

import java.util.LinkedList;
import java.util.List;

public class Dealer extends Mafiot implements ICarrier{
    String stock = "";

    public Dealer(double income, String nickname, String stock) {
        super(income, nickname);
        this.stock = stock;
    }

    @Override
    public void carry() {
        System.out.println(nickname + " I carry " + stock);
    }
}