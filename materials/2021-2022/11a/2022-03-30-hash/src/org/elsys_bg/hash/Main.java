package org.elsys_bg.hash;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //does not guarantee the order
        Set<User> set = new HashSet<>();
        User user1 = new User(1, "Ivana", "asdas");
        User user2 = new User(2, "Petkan", "asd");
        User user3 = new User(3, "Darin", "sgddfsg");
        User user4 = new User(4, "Martin", "xcvxcv");
        User user5 = new User(4, "Martin", "xcvxcv");
        set.add(user1);
        set.add(user2);
        set.add(user3);
        set.add(user4);
        set.add(user1);
        set.add(user5);
        set.add(null);

//        System.out.println(set);
//
//        System.out.println(set.contains(user1));
//        user1.setName("aklsfjklasj");
//        System.out.println(set.contains(user1));

        //key - value pairs
        Map<User, String> map = new HashMap<>();
        map.put(user1, "otlichnik");
        map.put(user2, "dvoikar");
        map.put(user3, "dvoikar");
        map.put(user1, "troikar");

        String value = map.get(user1);
        boolean contains = map.containsKey(user2);
        map.containsValue("chetvorkar");

        for(Map.Entry<User, String> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue();
        }

        for (User user : map.keySet()) {
            map.get(user);
        }

        Collection<String> values = map.values();


        System.out.println(map);

        Set<User> set1 = new LinkedHashSet<>(); // keeps the order of insertion
        Set<User> set2 = new TreeSet<>(); // stores data in ascending order, can't have null

        Map<User, String> map1 = new LinkedHashMap();//keeps the order of insertion
        Map<User, String> map2 = new TreeMap<>(); // stores data in ascending order, can't have null

        set1.add(user1);
        set1.add(user2);
        set1.add(user4);
        set1.add(user3);

        set2.add(user1);
        set2.add(user3);
        set2.add(user4);
        set2.add(user2);

        System.out.println(set);
        System.out.println(set1);
        System.out.println(set2);
    }
}
