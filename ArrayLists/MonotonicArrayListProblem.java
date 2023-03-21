package ArrayLists;

import java.util.ArrayList;

/* Problem states that we have been given an ArrayList
and we need to determine if the given ArrayList is mathematically
strictly increasing or strictly decreasing and return true if it is
and false if it is not.
 */
public class MonotonicArrayListProblem {
    // Linear Time Complexity
    public static boolean monotonocity(ArrayList<Integer> list) {
        int countIncreasing = 0,countDecreasing = 0;
        if(list.size() == 0 || list.size() == 1) {
            return true;
        }
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) <= list.get(i+1)) {
                countIncreasing++;
            }
            else {
                countDecreasing++;
            }
        }
        if(countIncreasing == list.size()-1 || countDecreasing == list.size()-1) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(3);
        list.add(2);
        System.out.println(monotonocity(list));
    }
}
