public class Bomb extends Figure {
    public Bomb(int x, int y) {
        super(x, y, FigureType.NONE);
    }

    @Override
    public void onSwap(Game g) {
//        super.onSwap(field);
    }

    @Override
    public String toString() {
        return "B";
    }
}
