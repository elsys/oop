package org.elsys.oop.candycrush;

public class BombCandy extends Candy {
    public BombCandy(Game game) {
        super(game);
        this.type = 0;
    }

    @Override
        public void display() {
            System.out.print("B");
        }
}
