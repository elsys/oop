public class Main {
    public static void main(String[] args) {
        FooSource s = new FooSource();
        Consumer c = new Consumer(s);
        Consumer c2 = new Consumer(s);
        Consumer c3 = new Consumer(s);

        try {
            s.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
