package ArrayLists;

import java.util.ArrayList;
import java.util.HashMap;

/*
You are given an integer Arraylist nums. You are also given an integer key, which is present in
nums.
For every unique integer target in nums, count the number of times target immediately follows an occurrence of key in nums.
In other words, count the number of indices i such that:
0 <= i <= nums.size() - 2,
nums.get(i) == key and,
nums.get(i+1) == target.
Return the target with the maximum count.
(Assumption - that the target with maximum count is unique.)
 */
public class MostFrequentNumber {
    public static int findMostFrequentNumber(ArrayList<Integer> list,int key) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        int target = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == key) {
                int currentTarget = list.get(i + 1);
                // Counts the frequency of the target through the getOrDefault method which has a defaultValue 0
                int currentCount = countMap.getOrDefault(currentTarget, 0) + 1;
                countMap.put(currentTarget, currentCount);
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    target = currentTarget;
                }
            }
        }
        return target;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        int answer = findMostFrequentNumber(list,2);
        System.out.println(answer);
    }
}
