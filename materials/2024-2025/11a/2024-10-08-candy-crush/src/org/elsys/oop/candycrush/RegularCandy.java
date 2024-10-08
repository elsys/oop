package org.elsys.oop.candycrush;

public class RegularCandy extends Candy {

    public RegularCandy(Game game) {
        super(game);
        this.type = (int) Math.floor(Math.random() * 4) + 1;
    }

    @Override
    public void display() {
        System.out.print(type);
    }
}
