package ArrayLists;
import java.util.ArrayList;


public class ContainerWithMostWaterProblem {
    // Brute Force Solution with O(n^2) time complexity
    /* Involves calculating the water stored by all possible pairs of bars
    and then calculating the maximum out of them
     */
    public static int bruteForceApproach(ArrayList<Integer> height) {
        int maxWater = 0;
        for(int i=0; i<height.size(); i++) {
            for(int j=i+1; j<height.size();j++) {
                int ht = Math.min(height.get(i),height.get(j));
                int width = j - i;
                int waterStored = ht * width;
                maxWater = Math.max(waterStored,maxWater);
            }
        }
        return maxWater;
    }
    // 2 Pointer approach with an optimised O(n) time complexity
    /*
    Amount of stored water depends directly upon the height of the smaller
    bar so we'll increment the height of the smaller bar and at each step calculate
    the maximum possible water stored until the pointers become equal to each other
    We have one pointer at the last index of the ArrayList and one at the first index.
     */
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int leftPointer = 0;
        int rightPointer = height.size() - 1;
        while(leftPointer < rightPointer) {
            // Calculating water stored
            int ht = Math.min(height.get(leftPointer),height.get(rightPointer));
            int width = rightPointer - leftPointer;
            int currentWater = ht * width;
            maxWater = Math.max(maxWater,currentWater);

            // Comparing the pointers
            if(leftPointer < rightPointer) {
                leftPointer++;
            }
            else {
                rightPointer++;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        int maxWater = storeWater(height);
        int maxWater2 = bruteForceApproach(height);
        System.out.println("Maximum possible water which can be stored is: "+maxWater);
        System.out.println("Maximum possible water which can be stored is: "+maxWater2);
    }
}
