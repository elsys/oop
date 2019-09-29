package org.elsys.threads;

public class WrongUsage {
    public static void main(String[] args) {
        try {
            new Object().wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Object().notify();
    }
}
