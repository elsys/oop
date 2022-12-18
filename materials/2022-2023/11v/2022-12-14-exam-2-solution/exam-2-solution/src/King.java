import java.util.List;

public class King extends Figure {
    public King(ChessGame cg, ChessGame.PlayerName owner, String pos) {
        super(cg, owner, pos, owner == ChessGame.PlayerName.WHITE ? 'G' : 'g');
    }

    @Override
    public boolean canMove(String pos) throws Exception {
        ChessGame.Pos start = ChessGame.Pos.fromString(this.pos);
        ChessGame.Pos end = ChessGame.Pos.fromString(pos);

        int distRow = Math.abs(start.row - end.row);
        int distCol = Math.abs(start.col - end.col);

        // Allow movement by 1 space in any direction
        if(distCol != 1 && distRow != 1)
            return false;

        // Check if the target is empty or enemy
        Figure destination = cg.getAt(pos);
        if(destination != null && destination.owner == owner)
            return false;

        return true;
    }

    public boolean isCheck() {
        // TODO: How to discover all enemy figures that can move to this.pos?
        return false;
    }

    public boolean isMate() {
        if(!isCheck()) return false;

        // TODO: How to discover all spaces I can move to without being in check?
        return false;
    }
}
