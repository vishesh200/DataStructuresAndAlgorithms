package ArrayLists;

import java.util.*;
/*
The problem says that in a given ArrayList find out the numbers
which are lonely i.e. if a number say 'i' is lonely then the values
i+1 and i-1 shouldn't exist in the ArrayList. We have to return the
ArrayList of lonely numbers using the given ArrayList.
 */
public class LonelyNumbersProblem {
    public static ArrayList<Integer> findLonelyNumbers(List<Integer> nums) {
        // Create a map to store the frequency of each number
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Iterate through the arraylist and update the frequency of each number in the map
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a list to store all lonely numbers
        ArrayList<Integer> lonelyNumbers = new ArrayList<>();

        for(int num:nums) {
            int frequency = frequencyMap.get(num);
            int frequencyOfPrev = frequencyMap.getOrDefault(num - 1, 0);
            int frequencyOfNext = frequencyMap.getOrDefault(num + 1, 0);

            if (frequency == 1 && frequencyOfPrev == 0 && frequencyOfNext == 0) {
                lonelyNumbers.add(num);
            }
        }
        return lonelyNumbers;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(27);
        list.add(3);
        ArrayList<Integer> answer = findLonelyNumbers(list);
        System.out.println(answer);
    }
}
