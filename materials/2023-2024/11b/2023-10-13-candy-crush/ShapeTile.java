import java.util.Random;

public class ShapeTile extends Tile {
    public ShapeTile(Tile[][] field) {
        super(field);
        variant = new Random().nextInt(4);
    }

    @Override
    public void print() {
        System.out.print(variant);
    }

    // Search in all directions for a straight line of identical tiles that's 3 or more long
    @Override
    public void processSwap() {
        int startX = x;
        int endX = x;

        // Search left and right for same tiles
        while(startX - 1 >= 0 && field[startX - 1][y] != null && field[startX - 1][y].variant == variant) startX--;
        while(endX < 5 && field[endX][y] != null && field[endX][y].variant == variant) endX++;

        // If the the line is 3 or more clear it
        if(endX - startX >= 3)
            for(int i = startX; i < endX; i++) field[i][y] = null;

        int startY = y;
        int endY = y;

        // Same for up and down
        while(startY - 1 >= 0 && field[x][startY - 1] != null && field[x][startY - 1].variant == variant) startY--;
        while(endY < 5 && field[x][endY] != null && field[x][endY].variant == variant) endY++;

        if(endY - startY >= 3)
            for(int i = startY; i < endY; i++) field[x][i] = null;
    }
}