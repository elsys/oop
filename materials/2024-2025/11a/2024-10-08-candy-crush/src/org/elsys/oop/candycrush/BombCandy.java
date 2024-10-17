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

    @Override
    public void onSwap(Coordinate coordinate) {
        // TODO: Check for IndexOutOfBound
        // Kaboom
        for (int i = coordinate.x() - 1; i <= coordinate.x() + 1; i++) {
            for (int j = coordinate.y() - 2; j >= 0; j--) {
                game.board[i][j + 3] = game.board[i][j];
            }
        }

        // Fill upper board
        for (int i = coordinate.x() - 1; i <= coordinate.x() + 1; i++) {
            for (int j = 0; j < 3; j++) {
                game.createCandy(i, j);
            }
        }
    }


}
