package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;

        double ratio[][] = new double[val.length][2];

        for(int i=0; i<val.length; i++) {
            ratio[i][0] = i; // Index is stored at 0th index
            ratio[i][1] = val[i] / (double) weight[i]; // Profit/Weight ratio is stored at 1st index
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        System.out.println("Index   Ratio");
        for(int i=0; i<val.length; i++) {
            System.out.println(ratio[i][0]+"    "+ratio[i][1]);
        }
        System.out.println();

        int currCapacity = W;
        int totalValue = 0;

        for(int i=ratio.length-1; i>=0; i--) {

            int idx = (int)ratio[i][0];

            // Include the complete item if weight of item is less than current capacity
            if(currCapacity >= weight[idx]) {
                currCapacity -= weight[idx];
                totalValue += val[idx];
            } else {
                // Include fractional part of the item
                totalValue += ratio[i][1] * currCapacity;
                currCapacity = 0;
                break;
            }
        }

        System.out.println("Maximum possible profit obtained is : "+totalValue);
    }
}

