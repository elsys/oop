import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    static private class CapitalsComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int capitals1 = 0;
            int capitals2 = 0;

            return capitals1 - capitals2;
        }
    }

    static private int countCapitals(String s) {
        return 0;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        strings.add("dnseo ASDjidnsa a");
        strings.add("fn4y87dsio");
        strings.add("mkdKOd DHu$$");
        strings.add("dnseo ASDji a");

//        strings.sort();
        Collections.sort(strings);

//        strings.sort(new Comparator(...));

        CapitalsComparator comp = new CapitalsComparator();
        strings.sort(comp);
        strings.sort(new CapitalsComparator());

        Comparator<String> comp2 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int capitals1 = 0;
                int capitals2 = 0;

                return capitals1 - capitals2;
            }
        };
        strings.sort(comp2);
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int capitals1 = 0;
                int capitals2 = 0;

                return capitals1 - capitals2;
            }
        });

        Comparator<String> comp3 = (o1, o2) -> {
            int capitals1 = 0;
            int capitals2 = 0;

            return capitals1 - capitals2;
        };
        strings.sort(comp3);
        strings.sort((o1, o2) -> {
            int capitals1 = countCapitals(o1);
            int capitals2 = countCapitals(o2);

            return capitals1 - capitals2;
        });
        strings.sort((s1, s2) -> countCapitals(s1) - countCapitals(s2));
        strings.sort(Comparator.comparingInt(Main::countCapitals));


        modifyStrings(strings, (s) -> s);

        List<Integer> l = new ArrayList<>();
        for (String str :strings) {
            l.add(str.length());
        }

//        List<Integer> lengths = strings
        long finalCount = strings
                .stream()
                //.map((str) -> str.length())
                .filter((str) -> str.length() > 4)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String str) {
                        return str.length() > 4;
                    }
                })
                .limit(3)
                //.collect(Collectors.toList());
                .count();
        System.out.println(finalCount);
    }

static List<String> modifyStrings(List<String> strings, StringModifier sm) {
        sm.modify(strings.get(0));
        return null;
    }
}
