import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
//        list.add(Integer.getInteger("123"));
        list.add(123);
//        list.add(true);

        MyList<Integer> list2 = new MyList<>();
//        list2.add(123);

        MyList<Integer> list3 = MyList.<Integer>fromArray(
                new Integer[]{1, 2, 3}
        );

        list3.<Object>foo();

        list2.sort((o1, o2) -> o1.hashCode() - o2.hashCode());
        list2.sort((o1, o2) -> o1 - o2);

        list3.sort(Comparator.comparingInt(Object::hashCode));
        list3.sort(Comparator.comparingInt(o -> o));

        list3.sort();

        MyList<Main> list4 = new MyList<Main>();
    }
}
