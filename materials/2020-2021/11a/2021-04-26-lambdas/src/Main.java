import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static private class CapitalsComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int capitals1 = 0; // count capitals in o1
            int capitals2 = 0; // count capitals in o2

            return capitals1 - capitals2;
        }
    }

    static private int capitals(String s) {
        return 0;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        strings.add("njknkja&DS8934");
        strings.add("adu543u9HUS asjd89a");
        strings.add("mdsa98qd f6d7d3");
        strings.add("kad89 D*(Sd sag78");

        Collections.sort(strings);

        System.out.println(strings);
        //strings.so

        CapitalsComparator comp1 = new CapitalsComparator();
        strings.sort(comp1);
        strings.sort(new CapitalsComparator());

        Comparator<String> comp2 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int capitals1 = 0; // count capitals in o1
                int capitals2 = 0; // count capitals in o2

                return capitals1 - capitals2;
            }
        };
        strings.sort(comp2);
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int capitals1 = 0; // count capitals in o1
                int capitals2 = 0; // count capitals in o2

                return capitals1 - capitals2;
            }
        });

        Comparator<String> comp3 = (o1, o2) -> {
            int capitals1 = 0; // count capitals in o1
            int capitals2 = 0; // count capitals in o2

            return capitals1 - capitals2;
        };
        Comparator<String> comp4 = (o1, o2) -> capitals(o1) - capitals(o2);
        strings.sort(comp3);
        strings.sort(comp4);
        strings.sort((o1, o2) -> capitals(o1) - capitals(o2));
        strings.sort(Comparator.comparingInt(Main::capitals));

        modifyStrings(strings, (s) -> s.concat("123"));
        modifyStrings(strings, (s) -> s.substring(0, 4));

        List<Double> lengths = strings
                .stream()
                .filter((s) -> s.charAt(0) != 'a')
                .map((s) -> s.length())
                .map((i) -> i.doubleValue())
                .distinct()
                .limit(4)
                //.count();
                .collect(Collectors.toList());
    }

static private void modifyStrings(List<String> strings, StringModifier sm) {
        //sm.modify(strings.get(0));
        for(String str: strings) {
            sm.modify(str);
        }
    }
}
