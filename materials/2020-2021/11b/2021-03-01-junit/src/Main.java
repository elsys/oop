public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int result = m.factoriel(7);
        System.out.println(result);
    }

    int factoriel(int target) {
        // print target!
        // System.out.println(5040);
        if(target <= 1) {
            return 1;
        }

        if(target > 20) {
            throw new IllegalArgumentException();
        }

        return target * factoriel(target - 1);
    }
}
