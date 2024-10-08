package org.elsys.oop.candycrush;

public record Coordinate(int x, int y) {

    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }

    public Coordinate neighbour(Direction direction) {
        return switch (direction) {
            case Left -> new Coordinate(x - 1, y);
            case Right -> new Coordinate(x + 1, y);
            case Up -> new Coordinate(x, y - 1);
            case Down -> new Coordinate(x, y + 1);
        };
    }

    public boolean isInBoard(int boardSize) {
        return x >= 0 && y >= 0 && x < boardSize && y < boardSize;
    }
}
