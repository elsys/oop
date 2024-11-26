import java.util.*;
import java.util.function.Function;

public class Main {
    private static class CompareStrings implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.charAt(1) - o2.charAt(1);
        }
    }

    @FunctionalInterface
    private static interface MyLambda {
        public void foo(int arg);
//        public void foo(int arg, int arg2);
//        public default void bar() {}
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("123");
        strings.add("456");

//        Collections.sort(strings, new CompareStrings());
//        Collections.sort(strings, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.charAt(1) - o2.charAt(1);
//            }
//        });
//        Collections.sort(
//                strings,
//                (o1, o2) -> {
//                    char c1 = o1.charAt(1);
//                    char c2 = o2.charAt(1);
//                    return c1 - c2;
//                }
//        );
//        Collections.sort(
//                strings,
//                (o1, o2) ->
//                        o1.charAt(1) - o2.charAt(1)
//        );
        Collections.sort(
                strings,
                Comparator.comparingInt(o -> o.charAt(1))
        );

        List<String> example = new List<String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public String get(int index) {
                return "";
            }

            @Override
            public String set(int index, String element) {
                return "";
            }

            @Override
            public void add(int index, String element) {

            }

            @Override
            public String remove(int index) {
                return "";
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<String> listIterator() {
                return null;
            }

            @Override
            public ListIterator<String> listIterator(int index) {
                return null;
            }

            @Override
            public List<String> subList(int fromIndex, int toIndex) {
                return List.of();
            }
        };


//        MyLambda myFoo = (arg) -> System.out.println(arg);
        MyLambda myFoo = System.out::println;
        myFoo.foo(123);

        example.forEach(System.out::println);
        Function<String, Integer> f = (a1) -> {
            return a1.length();
        };
        System.out.println(f.apply("foo"));
    }
}