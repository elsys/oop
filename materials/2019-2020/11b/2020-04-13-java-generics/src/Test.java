/*public class Test2 extends Serializable{

        }*/

import java.util.List;

public class Test <T extends Number/* & List*/> {
    // в метод
    // променливи
    // конструктор
    // return

    int size;
    private T item;

    public Test(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }

    static <S> void fn(S arg) {
        System.out.println(arg);
    }
}
