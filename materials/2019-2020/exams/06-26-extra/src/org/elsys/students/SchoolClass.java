package org.elsys.students;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SchoolClass {
    private List<Student> students;
    // Basic way by using just threads
//    private List<Thread> studentThreads = new ArrayList<>();
    // Better way by using an executor service
    private ExecutorService threadService = Executors.newScheduledThreadPool(5);

    public SchoolClass(List<Student> students) {
        this.students = students;
        String names = students.stream()
                .map((s) -> s.getName())
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println("Class: Created class with students " + names);

//        students.forEach((student) -> {
//            Thread thread = new Thread(student);
//            thread.start();
//            studentThreads.add(thread);
//        });
        students.forEach((student) -> threadService.execute(student));
        System.out.println("Class: Started threads for all students");
    }

    public void assignHomework(List<String> homework, int remainingTime) throws InterruptedException {
        System.out.println("Class: Assigning homework to all students: " + homework);
        students.forEach((student) -> student.doHomework(homework));

        Thread.sleep(remainingTime);
        System.out.println("Class: Time is out!");
//        for (Thread studentThread : studentThreads) {
//            studentThread.interrupt();
//        }
        threadService.shutdownNow();
        // Wait to ensure all threads are finished. Not always necessary.
        threadService.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Class: Students with unfinished homework:");
        String names = students.stream()
                .filter((student) -> student.getRemainingHomework().size() > 0)
                .map((student) -> student.getName() + " " + student.getRemainingHomework())
                .collect(Collectors.joining("\n"));
        System.out.println(names);
    }
}
