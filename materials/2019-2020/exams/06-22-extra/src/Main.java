import org.elsys.jobs.JobRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        if(args.length < 1) {
            throw new IllegalArgumentException();
        }

        int threadCount = Integer.valueOf(args[0]);
        JobRunner jr = new JobRunner(threadCount);
        (new Thread(jr, "Job Master")).start();

        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Enter new jobs:");
                String line = sc.nextLine();
                List<Integer> jobs = Arrays.stream(line.split(" "))
                        .map((num) -> Integer.valueOf(num))
                        .collect(Collectors.toList());
                jr.processJobs(jobs);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
