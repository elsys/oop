public class ChessGame {
    public Object[] board = {
            new Object()
    };

    public Object getAt(String pos) {
        if(pos.length() != 2)
            throw new IllegalArgumentException("Invalid position");

        return board[0];
    }
}
