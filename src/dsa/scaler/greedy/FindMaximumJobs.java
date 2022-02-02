package dsa.scaler.greedy;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindMaximumJobs {
    public static void main(String[] args) {
        FindMaximumJobs fmj = new FindMaximumJobs();
        System.out.println(fmj.solve(Utils.generateList(3,2,6),Utils.generateList(9,8,9)));
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            jobs.add(new Job(A.get(i),B.get(i)));
        }
        jobs.sort(Comparator.comparing(j -> j.endTime));
        Job prev = null;
        int totalJobs = 0;
        for(Job job :jobs){
            if(prev != null && prev.endTime > job.startTime){
                continue;
            }

            prev = job;
            totalJobs++;
        }
        return totalJobs;
    }

    static class Job{
        int startTime;
        int endTime;
        Job(int startTime,int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
