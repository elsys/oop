import java.util.Random;

public class BombTile extends Tile {
    public BombTile(Tile[][] field) {
        super(field);
        variant = 5;
    }

    @Override
    public void print() {
        System.out.print("B");
    }

    // Clear all tiles in a 3x3 area
    @Override
    public void processSwap() {
        System.out.println("BOOM");
        for(int x = Math.max(0, this.x - 1); x <= Math.min(6, this.x + 1); x++) {
            for(int y = Math.max(0, this.y - 1); y <= Math.min(6, this.y + 1); y++) {
                field[x][y] = null;
            }
        }
    }
}