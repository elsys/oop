package org.elsys_bg.map;

import java.util.HashMap;
import java.util.Map;

public class Maps {

    public static void main(String[] args) {
        Maps m = new Maps();
        m.test();

        String s = new String();
        String s2 = s + "asdsad";
        s2.hashCode();
    }
    Map<Integer, String> map = new HashMap();

    public void test() {
        map.put(1, "one");
        map.put(1, "two");
        System.out.println(map.get(2));
        map.keySet();
        map.values();
        map.remove(1);
        map.containsKey(1);

        for(Integer key : map.keySet()) {

        }
    }
}
