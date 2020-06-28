package org.elsys.jobs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobRunner implements Runnable {
    private int maxThreads;
    private ExecutorService threadService;
    private List<JobExecutor> runningJobExecutors = new LinkedList<>();
    private List<Integer> jobsToAdd;

    public JobRunner(int maxThreads) {
        this.maxThreads = maxThreads;
        threadService = Executors.newFixedThreadPool(maxThreads);
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    wait();
                }

                synchronized (runningJobExecutors) {
                    System.out.println("Adding jobs: " + jobsToAdd);
                    for (Integer newJob : jobsToAdd) {
                        JobExecutor best = findBestExecutor();
                        best.queueJob(newJob);
                    }

                    System.out.println(runningJobExecutors);
                    jobsToAdd = null;
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void processJobs(List<Integer> jobs) {
        jobsToAdd = new LinkedList<>(jobs);
        synchronized (this) {
            notify();
        }
    }

    private JobExecutor findBestExecutor() {
        if(runningJobExecutors.size() < maxThreads) {
            System.out.println("Create new executor");
            JobExecutor newExecutor = new JobExecutor(this);
            runningJobExecutors.add(newExecutor);
            threadService.execute(newExecutor);
            return newExecutor;
        }

        System.out.println("Add to running executor");
        return runningJobExecutors.stream()
                .sorted(Comparator.comparingInt(JobExecutor::getTotalJobTime))
                .findFirst()
                .get();
    }

    public synchronized void inform(JobExecutor finishedExecutor) {
        synchronized (runningJobExecutors) {
            System.out.println("Removing executor " + finishedExecutor);
            runningJobExecutors.remove(finishedExecutor);
            System.out.println(runningJobExecutors);
        }
    }
}
