import java.util.List;

public class Knight extends Figure {
    public Knight(ChessGame cg, ChessGame.PlayerName owner, String pos) {
        super(cg, owner, pos, owner == ChessGame.PlayerName.WHITE ? 'K' : 'k');
    }

    @Override
    public boolean canMove(String pos) throws Exception {
        ChessGame.Pos start = ChessGame.Pos.fromString(this.pos);
        ChessGame.Pos end = ChessGame.Pos.fromString(pos);

        // TODO: How to validate the movement is in the correct shape?
        // All possibilities:
        // up up up left
        // up up up right
        // left left left up
        // left left left down
        // down down down left
        // down down down right
        // right right right up
        // right right right down

        // Check if the target is empty or enemy
        Figure destination = cg.getAt(pos);
        if(destination != null && destination.owner == owner)
            return false;

        return true;
    }
}
