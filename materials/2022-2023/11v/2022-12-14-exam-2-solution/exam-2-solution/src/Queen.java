import java.util.List;

public class Queen extends Figure {
    public Queen(ChessGame cg, ChessGame.PlayerName owner, String pos) {
        super(cg, owner, pos, owner == ChessGame.PlayerName.WHITE ? 'Q' : 'q');
    }

    @Override
    public boolean canMove(String pos) throws Exception {
        ChessGame.Pos start = ChessGame.Pos.fromString(this.pos);
        ChessGame.Pos end = ChessGame.Pos.fromString(pos);

        // ChessGame.getInRange will handle the validation if the movement is a straight line

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
