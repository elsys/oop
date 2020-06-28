package org.elsys.students;

import java.util.*;

public class Student implements Runnable {
    private static int baseHomeworkTime = 2000;
    private static int restTime = 500;

    private String name;
    private int number;
    private Map<String, Integer> subjectStrength;
    private Queue<String> homework;

    public Student(String name, int number, Map<String, Integer> subjectStrength) {
        this.name = name;
        this.number = number;
        this.subjectStrength = subjectStrength;
        log("Created");
    }

    @Override
    public void run() {
        try {
            log("Waiting for homework.");
            synchronized (this) {
                wait();
            }

            while(homework.size() > 0) {
                String hw = homework.element();
                log("Doing " + hw);
                Thread.sleep(Student.baseHomeworkTime / subjectStrength.get(hw));
                homework.remove();
                log("Is done with " + hw + ". Resting now.");
                Thread.sleep(Student.restTime);
                log("Done resting.");
            }

            log("Done with homework.");
        } catch (InterruptedException e) {
            log("Was interrupted. Can't do more homework.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doHomework(List<String> homework) {
        this.homework = new ArrayDeque<>(homework);
        synchronized (this) {
            notify();
        }
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Map<String, Integer> getSubjectStrength() {
        return subjectStrength;
    }

    public Queue<String> getRemainingHomework() {
        return homework;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", subjectStrength=" + subjectStrength +
                '}';
    }

    private void log(String message) {
        System.out.println("Student " + name + ": " + message);
    }
}
