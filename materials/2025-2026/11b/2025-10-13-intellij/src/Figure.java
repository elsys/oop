public class Figure {
    private int x;
    private int y;
    private FigureType type;

    public Figure(int x, int y, FigureType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void onSwap(Game g) {
        // ???
    }

    @Override
    public String toString() {
        return type + "";
    }
}
