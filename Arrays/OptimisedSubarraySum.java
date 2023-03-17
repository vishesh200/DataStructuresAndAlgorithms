package Arrays;

import java.util.Arrays;

public class OptimisedSubarraySum {
   public static void kadanes(int[] arr) {
       int currentSum = 0;
       int maxSum = Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++) {
           currentSum += arr[i];
           if(currentSum < 0) {
               currentSum = 0;
           }
           maxSum = Math.max(currentSum,maxSum);
       }
       if(maxSum == 0) {
           Arrays.sort(arr);
           System.out.println("Maximum subarray sum for the given array is: "+arr[arr.length-1]);
       }
       else {
           System.out.println("Maximum subarray sum for the given array is: "+maxSum);
       }
   }
    public static void main(String[] args) {
        int[] arr = {-21,-1,3,-2,-5};
        kadanes(arr);
    }
}
