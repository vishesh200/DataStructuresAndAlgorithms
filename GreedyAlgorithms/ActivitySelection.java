package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* We have been given the start as well as end times of activities of a
and we need to select maximum number of activities such that no two of them
occur simultaneously and only sequential execution of activities is possible. */

public class ActivitySelection {
    public static void main(String[] args) {
        // The given end times are not sorted in ascending order
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int maxActivities = 0;

        int[][] activities = new int[end.length][3];

        for (int i=0; i<end.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(activities[0][0]);
        int lastEndTime = activities[0][2];
        maxActivities = 1;

        for(int i=0; i<end.length; i++) {
            if(activities[i][1] >= lastEndTime) {
                ans.add(activities[i][0]);
                maxActivities++;
                lastEndTime = activities[i][2];
            }
        }

        System.out.println("Maximum possible activities are : "+maxActivities);
        for(int i=0; i<ans.size(); i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
    }
}
