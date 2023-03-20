package ArrayLists;

import java.util.ArrayList;

/* Given a sorted ArrayList, we need to find out if the target can be equalled by
 summing any two pairs of numbers present in the ArrayList */
public class PairSum {
    // O(n^2) time complexity
    public static boolean bruteForceApproach(ArrayList<Integer> list,int target) {
        for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j<list.size(); j++) {
                if(list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }
    // O(n) time complexity --> OPTIMISED APPROACH
    public static boolean optimisedPairSum(ArrayList<Integer> list,int target) {
        int leftPointer = 0;
        int rightPointer = list.size() - 1;
        while(leftPointer < rightPointer) {
            if(list.get(leftPointer) + list.get(rightPointer) == target) {
                return true;
            }
            else if(list.get(leftPointer) + list.get(rightPointer) < target) {
                leftPointer++;
            }
            else {
                rightPointer--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(bruteForceApproach(list,3));
        System.out.println(optimisedPairSum(list,3));

        System.out.println(bruteForceApproach(list,10));
        System.out.println(optimisedPairSum(list,10));

    }
}
