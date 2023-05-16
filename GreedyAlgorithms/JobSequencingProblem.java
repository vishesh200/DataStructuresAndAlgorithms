package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencingProblem {
    static class Job {
        private int id;
        private int profit;
        private int deadline;
        Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int[][] jobInfo = {{4,20},{1,10},{1,40},{1,30}};
        ArrayList<Job> jobs = new ArrayList<Job>();

        for(int i=0; i<jobInfo.length; i++) {
            jobs.add(new Job(i,jobInfo[i][0],jobInfo[i][1]));
        }

        /* This line sorts the job objects in the jobs arraylist
        in descending order of their profits */
        Collections.sort(jobs,(a,b) -> b.profit - a.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;

        for(int j=0; j<jobs.size(); j++) {
            Job currJob = jobs.get(j);
            if(currJob.deadline > time) {
                seq.add(currJob.id);
                time++;
            }
        }

        System.out.println("Maximum possible jobs are : "+seq.size());
        for(int k=0; k<seq.size(); k++) {
            System.out.println(seq.get(k)+" ");
        }
    }
}
