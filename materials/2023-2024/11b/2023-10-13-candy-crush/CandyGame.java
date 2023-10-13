public class CandyGame {
    public static void main(String[] args) {
        CandyGame game = new CandyGame();

        game.print();

        // Test swapping and removing tiles
        // game.swapTiles(0, 0, 1, 0);
        // game.print();

        // Test the bomb
        game.swapTiles(2, 2, 1, 2);
        game.print();
    }

    private int fieldSize = 6;
    private Tile[][] field;

    CandyGame() {
        field = new Tile[fieldSize][fieldSize];
        for(int x = 0; x < fieldSize; x++) {
            for(int y = 0; y < fieldSize; y++) {
                setTile(x, y, new ShapeTile(field));
            }
        }

        // Create test tiles
        field[0][0].variant = 1;
        field[1][0].variant = 0;
        field[2][0].variant = 1;
        field[3][0].variant = 1;

        field[0][1].variant = 0;
        field[0][2].variant = 0;

        setTile(1, 2, new BombTile(field));
    }

    public void print() {
        for(int y = 0; y < fieldSize; y++) {
            for(int x = 0; x < fieldSize; x++) {
                if(field[x][y] != null) 
                    field[x][y].print();
                else
                    System.out.print("E");

                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < fieldSize && y < fieldSize;
    }

    private void setTile(int x, int y, Tile tile) {
        field[x][y] = tile;

        tile.x = x;
        tile.y = y;
    }

    public void swapTiles(int x1, int y1, int x2, int y2) {
        // must be inside the field
        if(!isInBounds(x1, y1) || !isInBounds(x2, y2)) 
            return; // throw new Exception

        // must be adjacent
        if(Math.abs(x1 - x2) > 1 || Math.abs(y1 - y2) > 1)
            return;

        // not diagonal
        if(Math.abs(x1 - x2) + Math.abs(y1 - y2) != 1)
            return;

        // must result in tiles being removed
        // TODO: Define checks in the tiles that swapping them will remove at least 1 tile

        System.out.println("Swap tiles (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ")");

        Tile t1 = field[x1][y1];
        Tile t2 = field[x2][y2];

        setTile(x1, y1, t2);
        setTile(x2, y2, t1);

        t1.processSwap();
        t2.processSwap();
    }
}
