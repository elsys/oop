package org.elsys.jobs;

import java.util.ArrayDeque;
import java.util.Queue;

public class JobExecutor implements Runnable {
    private Queue<Integer> jobs = new ArrayDeque<>();
    private JobRunner master;

    public JobExecutor(JobRunner master) {
        this.master = master;
    }

    @Override
    public void run() {
        try {
            if(jobs.size() <= 0) {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + " is waiting for jobs");
                    wait();
                }
            }

            while(jobs.size() > 0) {
                int job = jobs.element();
                System.out.println(Thread.currentThread().getName() + " is processing job " + job);
                Thread.sleep(job);
                jobs.remove();
                System.out.println(Thread.currentThread().getName() + " is done with job " + job);
            }

            System.out.println(Thread.currentThread().getName() + " is done with all jobs");
            master.inform(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void queueJob(int job) {
        synchronized (this) {
            jobs.add(job);
            notify();
        }
    }

    public int getTotalJobTime() {
        return jobs.stream().reduce(0, (acc, job) -> acc + job);
    }

    @Override
    public String toString() {
        return "JobExecutor{" +
                "totalJobs=" + getTotalJobTime() +
                "jobs=" + jobs +
                '}';
    }
}
