public class Pawn extends Figure {
    public Pawn(ChessGame cg, ChessGame.PlayerName owner, String pos) {
        super(cg, owner, pos, owner == ChessGame.PlayerName.WHITE ? 'P' : 'p');
    }

    @Override
    public boolean canMove(String pos) throws Exception {
        ChessGame.Pos start = ChessGame.Pos.fromString(this.pos);
        ChessGame.Pos end = ChessGame.Pos.fromString(pos);

        Figure destination = cg.getAt(pos);

        // Allow to move only 1 space vertically
        if(start.row != end.row + (owner == ChessGame.PlayerName.WHITE ? -1 : 1))
            return false;

        // Allow to move vertically ...
        if(start.col - end.col == 0)
            // ... if the target is unoccupied
            if(destination == null)
                return true;
            else return  false;

        // Allow to move diagonally...
        if(Math.abs(start.col - end.col) == 1)
            // ... if the target is occupied by an enemy
            if(destination != null && destination.owner != owner)
                return true;
            else return  false;

        return true;
    }
}
