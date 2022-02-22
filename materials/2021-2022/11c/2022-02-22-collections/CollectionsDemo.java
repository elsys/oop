package com.company;

import java.util.*;

public class CollectionsDemo {

    private final int seed;

    CollectionsDemo(int seed)
    {
        this.seed = seed;
    }

    public void generateRandomNumber(){
        System.out.println("Set seed for random: " + this.seed);
        Random rnd = new Random(this.seed);
        for (int idx = 0 ; idx < 20; idx++ ) {

            int number = rnd.nextInt();
            int boundedNumber = rnd.nextInt(10);

            System.out.println("rand:" + number);
            System.out.println("up to 10: " + boundedNumber);
        }
    }

    public void arrayDemo() {
        // initialization with size
        String[] array_0 = new String[5];

        // initialization with data
        String[] array = new String[] { "alfa", "bravo", "charlie", "delta", "echo" };

        // initialization with size
        int[][] numbers_0 = new int[2][3];

        // initialization with data
        int[][] numbers_1 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        // jagged array
        int[][] jagged_array_0 = new int[][]  {
                new int[] {1, 2, 3 ,4},
                new int[] {5, 6, 7, 8, 9, 10},
                new int[] {11, 12}
        };

        //
        int[][] jagged_array_1 = new int[3][];
        jagged_array_1[0] = new int[]{1,2,3,4,5,6};
        jagged_array_1[1] = new int[]{2,3,4,5,6};
        jagged_array_1[1] = new int[]{3,4,5,6};
    };

    // https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java
    // Each ArrayList instance has a capacity. The capacity is the size of the array used to store the elements in the list.

    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html
    public void arrayList_Demo() {
        ArrayList<String> list = new ArrayList();
        list.add("alfa");
        list.add("bravo");
        list.add("charlie");
        list.add("delta");
        list.add("echo");

        ArrayList<String> numbers = new ArrayList<String>();
        numbers.add("1st");
        numbers.add("2nd");
        numbers.add("3rd");

        list.addAll(numbers);

        try {
            list.remove(10);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        System.out.println("----------- for loop -----------");
        for (int idx = 0; idx < list.size(); idx++) {
            System.out.println("#" + idx + ": " + list.get(idx) );
        }

        System.out.println("----------- iterator -----------");
        Iterator<String> itr = list.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

        System.out.println("----------- before and after clear -----------");
        System.out.println(list.isEmpty());
        list.clear();
        System.out.println(list.isEmpty());
    }

    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/LinkedList.html
    // Operations that index into the list will traverse the list from the beginning or the end, whichever is closer to the specified index.
    public void linkedList_Demo() {
        LinkedList<String> linked = new LinkedList<String>();
        linked.add("alfa");
        linked.add("bravo");
        linked.add("charlie");
        linked.add("delta");
        linked.add("echo");

        System.out.println(linked.peek());      // Retrieves, but does not remove, the head (first element) of this list.
        System.out.println(linked.peekFirst()); // Retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
        System.out.println(linked.peekLast());  // Retrieves, but does not remove, the last element of this list, or returns null if this list is empty.

        System.out.println(linked.poll());      // Retrieves and removes the head (first element) of this list.
        System.out.println(linked.pollFirst()); // Retrieves and removes the first element of this list, or returns null if this list is empty.
        System.out.println(linked.pollLast());  // Retrieves and removes the last element of this list, or returns null if this list is empty.
        System.out.println(linked.pop());       // Pops an element from the stack represented by this list.
    }

    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Vector.html
    // However, the size of a Vector can grow or shrink as needed to accommodate adding and removing items after the Vector has been created.
    public void vector_Demo() {
        Vector<String> vector = new Vector<String>();
        vector.add("alfa");
        vector.add("bravo");
        vector.add("charlie");
        vector.add("delta");
        vector.add("echo");
        Iterator<String> itr = vector.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashSet.html
    public void hashSet_Demo() {
        int limit = 20;
        HashSet<Integer> set = new HashSet<Integer>();

        System.out.println("Set seed for random: " + this.seed);
        Random rnd = new Random(this.seed);

        while (limit-- > 0) {
            int number = rnd.nextInt();
            if (set.add(number)){
                System.out.println("added number '" + number + "' to set");
            }
        }
    }

    public void hashMap_Demo() {
        HashMap<Integer,String> map = new HashMap<Integer, String>();
        map.put(1,"alfa");
        map.put(2,"bravo");
        map.put(3,"charlie");
        map.put(4,"delta");
        map.put(5,"echo");
        for ( int idx = 0; idx < map.size(); idx++)
        {
            System.out.println("#" + idx + " = " + map.get(idx));
        }
    }

    public void stack_Demo() {
        Stack<String> stack = new Stack<String>();
        stack.push("alfa");
        stack.push("bravo");
        stack.push("charlie");
        stack.push("delta");
        stack.push("echo");

        System.out.println(stack.peek());

        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
