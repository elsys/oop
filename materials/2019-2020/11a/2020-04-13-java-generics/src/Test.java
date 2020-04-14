/*Type, S, U, V
Key
Element*/
/*
public interface Test2 extends Comparable {

}*/

public class Test <T extends Number> {
    Long size;
    private T item;

    public Test(T item) {
        this.item = item;
        System.out.println(item.doubleValue());
    }

    public T get() {
        return item;
    }

    static <U> void fn(U arg) {
        System.out.println(arg);
    }
}
