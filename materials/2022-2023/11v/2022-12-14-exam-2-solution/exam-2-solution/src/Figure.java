public abstract class Figure {
    protected ChessGame cg;
    protected final ChessGame.PlayerName owner;
    public String pos;

    private char symbol;

    public Figure(ChessGame cg, ChessGame.PlayerName owner, String pos, char symbol) {
        this.cg = cg;
        this.owner = owner;
        this.pos = pos;
        this.symbol = symbol;
    }

    public void move(String pos) throws Exception {
        if(!cg.validatePos(pos))
            throw new Exception("Invalid position");

        Figure target = cg.getAt(pos);
        if(target != null && target.owner == owner)
            throw new Exception("Same owner");

        if(!canMove(pos))
            throw new Exception("Invalid movement");

        cg.moveFigure(this.pos, pos);
    }

    public abstract boolean canMove(String pos) throws Exception;

    @Override
    public String toString() {
        return symbol + "";
    }
}
