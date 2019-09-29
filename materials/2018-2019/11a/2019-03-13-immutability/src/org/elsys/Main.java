package org.elsys;

import java.lang.reflect.Field;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	    final HashSet<Employee> employees = new HashSet<>();
	    employees.add(new Employee("Ivan", 1));
        final Employee ivan2;
        if (args.length > 0) {
            ivan2 = new Employee("Ivan", 2);
        } else {
            ivan2 = new Employee("Ivan", 5);
        }
        // ivan2 = new Employee("Ivan", 3); Won't compile!!
        employees.add(ivan2);
        System.out.println(employees);
        //setId(ivan2, 1);
        System.out.println(employees);

//        employees.add(new EmployeeHackChild("Ivan", 4));
//        employees.add(new EmployeeHackChild("Ivan", 5));
        System.out.println(employees);
    }

    /*
        Can't prevent immutable classes from reflection
     */
    private static void setId(Employee ivan2, long id) {
        try {
            // can use also ivan2.getClass()
            Field field = Employee.class.getDeclaredField("id");
            field.setAccessible(true);
            field.set(ivan2, id);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
