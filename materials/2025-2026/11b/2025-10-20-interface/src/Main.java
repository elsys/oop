import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyParent obj1 = new MyParent() {
            @Override
            public void foo() {

            }
        };
//        MyParent obj2 = new MyParent();
        MyParent obj3 = new MyChild();

        System.out.println(obj1);
        System.out.println(obj3);
        obj3.foo();

        IExample obj4 = new IExample() {
            @Override
            public void bar() {
                System.out.println("Anon::bar called");
            }
        };
//        obj3.bar();
        obj4.bar();
        ((MyChild)obj3).bar();
        ((IExample)obj3).bar();

        List<Object> list1 = new LinkedList<>();
        List<Object> list2 = new ArrayList<>();

//        Map<String, MyChild> map1 = new HashMap<>();
        TreeMap<MyParent, MyChild> map1 = new TreeMap<>();
        map1.put(new MyChild(), new MyChild());
        map1.put(new MyChild(), new MyChild());

        Book b1 = new Book();
        b1.size = 100;
        Book b2 = new Book();
        b2.size = 50;
        System.out.println(b1.compareTo(b2));

        Comparator<Book> cmp = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.year - o2.year;
            }
        };
        System.out.println(cmp.compare(b1, b2));
        System.out.println(Book.compareByYear.compare(b1, b2));
    }
}