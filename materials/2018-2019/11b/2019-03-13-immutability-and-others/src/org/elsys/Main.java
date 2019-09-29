package org.elsys;

import java.lang.reflect.Field;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	    final HashSet<SectMember> sect = new HashSet<>();
	    sect.add(new SectMember(1, 1, "Ivan"));
        SectMember ivan2 = new SectMember(2, 1, "Ivan");
        sect.add(ivan2);
        System.out.println(sect);

//        ivan2.setId(1);

//        employee.add(new SectMemberHack(1, 1, "Ivan"));
//        employee.add(new SectMemberHack(3, 1, "Ivan"));

        setId(ivan2, 1);
        System.out.println(sect);
        ivan2.getName().concat(" Ivanov");

        System.out.println(sect);
    }

    private static void setId(SectMember sm, int id) {
        try {
            // sm.getClass()
            Field field = SectMember.class.getDeclaredField("id");
            field.setAccessible(true);
            field.set(sm, id);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
