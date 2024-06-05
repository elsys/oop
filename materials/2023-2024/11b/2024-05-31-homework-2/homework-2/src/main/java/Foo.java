public class Foo implements Runnable {
    public int var = 5;

    public Foo() {}

    public Foo(int var) {
        this.var = var;
    }

    public static Foo factoryMethod1() {
        return new Foo();
    }

    public static Foo factoryMethod2() {
        return new Foo(15);
    }

    public void bar(int arg) throws Exception {
        if(arg > 5) throw new Exception("My exception");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
