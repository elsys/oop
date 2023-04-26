package org.elsys_bg;

public class Main {
    public static void main(String[] args) {
        Bean bean = new Bean(2);
        bean.setId(3);
        System.out.println(bean.getId());
    }
}