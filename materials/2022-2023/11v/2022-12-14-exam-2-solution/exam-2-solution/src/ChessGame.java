import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChessGame {
    public enum PlayerName {
        WHITE,
        BLACK
    };

    public static class Pos {
        public int row;
        public int col;

        public Pos(int col, int row) {
            this.col = col;
            this.row = row;
        }

        public static Pos fromString(String pos) {
            char col = pos.charAt(0);
            char row = pos.charAt(1);

            col -= 'A';
            row -= '1';

            return new Pos(col, row);
        }

        public static String fromCoords(int col, int row) {
            return (char)(col + 'A') + "" + (char)(row + '1') + "";
        }

        @Override
        public String toString() {
            return fromCoords(col, row);
        }

        public static boolean isVertical(Pos pos1, Pos pos2) {
            return pos1.row - pos2.row != 0 && pos1.col - pos2.col == 0;
        }

        public static boolean isHorizontal(Pos pos1, Pos pos2) {
            return pos1.row - pos2.row == 0 && pos1.col - pos2.col != 0;
        }

        public static boolean isDiagonal(Pos pos1, Pos pos2) {
            // Diagonals must be straight => |x1 - x2| must equal |y1 - y2|
            return Math.abs(pos1.col - pos2.col) == Math.abs(pos1.row - pos2.row);
        }
    }
    private final Figure[][] field;
    private PlayerName currPlayer = PlayerName.WHITE;
    private PlayerName winner = null;
    private King whiteKing = null;
    private King blackKing = null;

    public PlayerName getCurrPlayer() {
        return currPlayer;
    }

    public PlayerName getWinner() {
        return winner;
    }

    public ChessGame() {
        field = new Figure[8][8]; // 8 rows x 8 columns

        try {
            for (int i = 0; i < 8; i++) {
                switch (i) {
                    case 0, 7 -> {
                        setAt(Pos.fromCoords(i, 0), new Rook(this, PlayerName.WHITE, null));
                        setAt(Pos.fromCoords(i, 7), new Rook(this, PlayerName.BLACK, null));
                    }
                    case 1, 6 -> {
                        setAt(Pos.fromCoords(i, 0), new Bishop(this, PlayerName.WHITE, null));
                        setAt(Pos.fromCoords(i, 7), new Bishop(this, PlayerName.BLACK, null));
                    }
                    case 2, 5 -> {
                        setAt(Pos.fromCoords(i, 0), new Knight(this, PlayerName.WHITE, null));
                        setAt(Pos.fromCoords(i, 7), new Knight(this, PlayerName.BLACK, null));
                    }
                    case 3 -> {
                        setAt(Pos.fromCoords(i, 0), new Queen(this, PlayerName.WHITE, null));
                        setAt(Pos.fromCoords(i, 7), new Queen(this, PlayerName.BLACK, null));
                    }
                    case 4 -> {
                        whiteKing = new King(this, PlayerName.WHITE, null);
                        setAt(Pos.fromCoords(i, 0), whiteKing);
                        blackKing = new King(this, PlayerName.BLACK, null);
                        setAt(Pos.fromCoords(i, 7), blackKing);
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                setAt(Pos.fromCoords(i, 1), new Pawn(this, PlayerName.WHITE, null));
                setAt(Pos.fromCoords(i, 6), new Pawn(this, PlayerName.BLACK, null));
            }
        } catch (Exception ex) {
            // These sets should always be valid
        }
    }

    boolean validatePos(String pos) {
        Pos poss = Pos.fromString(pos);

        if(poss.row < 0 || poss.row > field.length)
            return false;
        if(poss.col < 0 || poss.col > field.length)
            return false;

        return true;
    }

    Figure getAt(String pos) throws Exception {
        Pos poss = Pos.fromString(pos);

        if(!validatePos(pos))
            throw new Exception("Invalid position");

        return field[poss.row][poss.col];
    }

    List<Figure> getInRange(String pos1, String pos2) throws Exception {
        ChessGame.Pos start = ChessGame.Pos.fromString(pos1);
        ChessGame.Pos end = ChessGame.Pos.fromString(pos2);

        // The range has to be a straight line in any direction
        if(!Pos.isHorizontal(start, end) && !Pos.isVertical(start, end) && !Pos.isDiagonal(start, end))
            throw new Exception("Invalid position range");

        List<Figure> figs = new ArrayList<>();

        int distance = Math.max(Math.abs(end.row - start.row), Math.abs(end.col - start.col));
        int rowDelta = (end.row - start.row) / distance;
        int colDelta = (end.col - start.col) / distance;

        for(int i = 0; i <= distance; i++) {
            figs.add(field[start.row + i * rowDelta][start.col + i * colDelta]);
        }

        return figs;
    }

    private void setAt(String pos, Figure fig) throws Exception {
        if(!validatePos(pos))
            throw new Exception("Invalid position");

        Pos position = Pos.fromString(pos);

        field[position.row][position.col] = fig;
        if(fig != null)
            fig.pos = pos;
    }

    void moveFigure(String pos1, String pos2) throws Exception {
        if(winner != null)
            throw new Exception("Game already finished");

        Figure fig1 = getAt(pos1);
        if(fig1 == null)
            throw new Exception("Pos1 is empty");
        if(fig1.owner != currPlayer)
            throw new Exception("Wrong owner");

        setAt(pos1, null);
        setAt(pos2, fig1);

        checkForWinner();
        currPlayer = currPlayer == PlayerName.WHITE ? PlayerName.BLACK : PlayerName.WHITE;
    }

    void checkForWinner() {
        if(blackKing.isMate())
            winner = PlayerName.WHITE;
        if(whiteKing.isMate())
            winner = PlayerName.BLACK;
    }

    void printBoard() {
        System.out.print("  ");
        for(int col = 0; col < field.length; col++)
            System.out.print((char)(col + 'A') + " ");
        System.out.println("");

        for(int row = 0; row < field.length; row++) {
            System.out.print((row + 1) + " ");

            for(int col = 0; col < field.length; col++) {
                Figure fig = field[row][col];
                if(fig == null)
                    System.out.print("- ");
                else
                    System.out.print(fig + " ");
            }
            System.out.println("");
        }
    }
}
