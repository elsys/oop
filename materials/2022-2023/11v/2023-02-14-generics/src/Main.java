import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyPriorityQueue<Integer> q = new MyPriorityQueue();

        Random rand = new Random();
        for(int i = 0; i < 10; i++) {
            q.add(rand.nextInt() % 100);
//            q.add(Integer.valueOf(i));
//            q.add((Object)Integer.valueOf(i));
        }

        try {
            while (true) {
                int val = q.remove();
                System.out.println(val);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
