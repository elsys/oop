public class Main {
    public static void main(String[] args) {
//        String[][] arr = new String[10][5];
////        for(int i = 0; i < 5; i++) {
////            for(int j = 0; j < 10; j++) {
////                arr[i][j] = i + "-" + j;
////            }
////        }
//        for(int x = 0; x < 10; x++) {
//            for(int y = 0; y < 5; y++) {
//                arr[x][y] = x + "-" + y;
//            }
//        }
//
//        for(int row = 0; row < 5; row++) {
//            for(int column = 0; column < 10; column++) {
//                System.out.print(arr[row][column] + " ");
//            }
//            System.out.println("");
//        }

        Game g = new Game();
        g.printBoard();

        g.moveFigure("A1", "A4");
        g.printBoard();
    }
}
