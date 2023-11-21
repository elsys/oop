public class MyClass {
    private MyClass() {}

    static MyClass foo(int arg) {
        return new MyClass();
    }
}
