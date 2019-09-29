package org.elsys.threads;

public class WrongExamples {
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
