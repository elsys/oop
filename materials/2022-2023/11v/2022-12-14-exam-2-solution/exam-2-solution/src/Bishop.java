import java.util.Iterator;
import java.util.List;

public class Bishop extends Figure {
    public Bishop(ChessGame cg, ChessGame.PlayerName owner, String pos) {
        super(cg, owner, pos, owner == ChessGame.PlayerName.WHITE ? 'B' : 'b');
    }

    @Override
    public boolean canMove(String pos) throws Exception {
        ChessGame.Pos start = ChessGame.Pos.fromString(this.pos);
        ChessGame.Pos end = ChessGame.Pos.fromString(pos);

        // Only allow diagonals
        if(!ChessGame.Pos.isDiagonal(start, end))
            return false;

        // Check all spaces in the range (start, end)
        List<Figure> figs = cg.getInRange(this.pos, pos);
        // Ignore the first and last item
        for(int i = 1; i < figs.size() - 1; i++)
            if(figs.get(i) != null)
                return false;

        // Check if the target is empty or enemy
        Figure destination = cg.getAt(pos);
        if(destination != null && destination.owner == owner)
            return false;

        return true;
    }
}
