import java.util.Random;
import java.util.Scanner;

public class Game {
    private Figure[][] field;

    public Game(int width, int height) {
        field = new Figure[height][width];

        for(int h = 0; h < field.length; h++) {
            Figure[] row = field[h];
            for(int w = 0; w < row.length; w++) {
                row[w] = generateFigure(w, h);
            }
        }
    }

    private Figure generateFigure(int w, int h) {
        Random rand = new Random();
        int percent = rand.nextInt(101);
        if(percent <= 80) {
            FigureType type = FigureType.BLUE;
            if(percent <= 20) type = FigureType.GREEN;
            else if (percent <= 40) type = FigureType.RED;
            else if (percent <= 60) type = FigureType.YELLOW;

            return new Figure(w, h, type); // color
        } else if (percent <= 90) {
            return new Bomb(w, h); // bomb
        } else {
            return new Figure(w, h, FigureType.NONE); // arrow
        }
    }

    public void printField() {
        for(int h = 0; h < field.length; h++) {
            Figure[] row = field[h];
            for(int w = 0; w < row.length; w++) {
//                System.out.print(row[w] + " ");
                System.out.print(row[w].toString() + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();

        Game g = new Game(width, height);
        g.printField();
    }
}
