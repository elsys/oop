import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "";
        System.out.println(s);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(0, 0);

//        int t = 6;
//        int b = t >> 1;
//        System.out.println(b);

//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }

        ArrayList<String> arrayList1 = new ArrayList<>();
        Iterator<String> iterator1 = arrayList1.iterator();


//        Iterator<Integer> iterator = arrayList.iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(0, 4);

//        for(int i = 0; i< linkedList.size(); i++) {
//            System.out.println(linkedList.get(i));
//        }


//        var iterator = linkedList.iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        for(var element : linkedList) {
//            System.out.println(element);
//        }

        Vector<Integer> vector = new Vector<>();

        Stack<Integer> st = new Stack<>();
        st.add(1);
        st.add(2);

        st.pop();
        st.push(3);

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.remove();

//        List<Element> list = new ArrayList<>();
        var list = new ArrayList<Element>();
        list.add(new Element(5));
        list.add(new Element(3));
        list.add(new Element(8));
        list.add(new Element(2));
        Comparator<Element> comparator = new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
//                return o1.getValue() - o2.getValue();
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        };
        for(var element : list) {
            System.out.println(element.getValue());
        }
        System.out.println("");
        list.sort(comparator);
        for(var element : list) {
            System.out.println(element.getValue());
        }
    }

    public void test(Collection s) {
        Object;
        List s1 = (List) s;

    }
}