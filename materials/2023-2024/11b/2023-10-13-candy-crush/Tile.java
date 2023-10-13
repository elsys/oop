
public class Tile {
    public int x = -1;
    public int y = -1;
    public int variant = -1;

    protected Tile[][] field;

    // Minimal dependency on the game and field to  let us remove tiles
    public Tile(Tile[][] field) {
        this.field = field;
    }

    // TODO: Make the class abstract:
    // public abstract void print();
    // public abstract void processSwap();

    // Let each tile define how it's printed in the console
    public void print() {
        System.out.print("Tile");
    };

    // Called after swapping to handle the result of moving the tile
    public void processSwap() {
        System.out.println("Not implemented");
    }
}