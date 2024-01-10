public class King extends Figure {
    public King(Game game, String owner, Game.Pos pos) {
        super(game, owner, pos, new char[] {'K', 'k'});
    }

    @Override
    protected boolean canMove(String pos) {
        return false;
    }

    public boolean isCheck() {
        return false;
    }

    public boolean isMate() {
        return false;
    }
}
