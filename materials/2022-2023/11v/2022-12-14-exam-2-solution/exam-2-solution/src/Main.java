import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessGame cg = new ChessGame();

        Scanner sc = new Scanner(System.in);
        while(cg.getWinner() == null) {
            cg.printBoard();

            System.out.println(cg.getCurrPlayer() + " turn:");

            boolean validMove = false;
            while(!validMove) {
                String start = sc.next();
                String end = sc.next();

                try {
                    Figure fig = cg.getAt(start);
                    fig.move(end);
                    validMove = true;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println(ex.getMessage());
                }
            }
        }

        cg.printBoard();
    }
}
