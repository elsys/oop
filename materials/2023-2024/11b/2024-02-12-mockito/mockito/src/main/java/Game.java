public class Game {
    private Figure[][] board;

    private King whiteKing = null;
    private King blackKing = null;

    public Game() {
        board = new Figure[8][8];

        board[0][0] = new Rook(this, "white", new Pos(0, 0));
        board[3][0] = whiteKing = new King(this, "white", new Pos(0, 3));

        board[0][7] = new Rook(this, "black", new Pos(7, 0));
        board[3][7] = blackKing = new King(this, "black", new Pos(7, 3));
    }

    public Figure getAt(String pos) {
        Pos newPos = stringToPos(pos);
        return board[newPos.row][newPos.col];
    }

    public void setAt(String pos, Figure fig) {
        Pos newPos = stringToPos(pos);
        board[newPos.row][newPos.col] = fig;
    }

    public void moveFigure(String start, String end) {
        Figure fig = getAt(start);
        fig.move(end);
    }

    public void printBoard() {
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                Figure fig = getAt(new Pos(row, col).toString());
                if(fig == null) System.out.print('-');
                else System.out.print(fig);
            }
            System.out.println("");
        }
    }

    public void checkForWinner() {
        if(whiteKing.isMate()) {
            System.out.println("Black wins");
        } else if(blackKing.isMate()) {
            System.out.println("White wins");
        }
    }

    public static class Pos {
        public int row;
        public int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            int r = 'A' + row;
            int c = '1' + col;
            return Character.toString(r) + Character.toString(c);
        }
    }

    public static Pos stringToPos(String pos) {
        int col = pos.charAt(0) - 'A';
        int row = pos.charAt(1) - '1';

        return new Pos(row, col);
    }
}
