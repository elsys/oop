public abstract class Figure {
    protected Game game;
    protected String owner;
    protected Game.Pos pos;

//    private char[] display;
    private char display;

    public Figure(Game game, String owner, Game.Pos pos, char[] display) {
        this.game = game;
        this.owner = owner;
        this.pos = pos;
//        this.display = display;
        this.display = owner.equals("white") ? display[0] : display[1];
    }

    public void move(String pos) {
        Game.Pos newPos = Game.stringToPos(pos);
//        1. validate pos is in board
        if(newPos.row < 0 || newPos.col < 0)
            throw new IllegalArgumentException("Invalid position");
        if(newPos.row > 7 || newPos.col > 7)
            throw new IllegalArgumentException("Invalid position");
//        2. validate with canMove
        if(!canMove(pos))
            throw new IllegalArgumentException("Cannot move to position");
//        3. validate field is empty or owner by oponent
        Figure targetCell = game.getAt(pos);
        if(targetCell != null && targetCell.owner == owner)
            throw new IllegalArgumentException("Cannot take own piece");
//        4. board[pos] = this
        game.setAt(newPos.toString(), this);
//        5. board[this.pos] = null
        game.setAt(this.pos.toString(), null);
//        6. this.pos = pos
        this.pos = newPos;
    }

    protected abstract boolean canMove(String pos);

    @Override
    public String toString() {
        return "" + display;
//        if(owner == "white")
//            return "" + display[0];
//        else
//            return "" + display[1];
    }
}
