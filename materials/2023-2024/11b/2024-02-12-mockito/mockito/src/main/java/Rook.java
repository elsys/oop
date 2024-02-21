public class Rook extends Figure {
    public Rook(Game game, String owner, Game.Pos pos) {
        super(game, owner, pos, new char[] {'R', 'r'});
    }

    @Override
    protected boolean canMove(String pos) {
        return true;
    }
}
