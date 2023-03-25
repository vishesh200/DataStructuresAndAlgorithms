package ArrayLists;

import java.util.ArrayList;

public class BeautifulArrayListProblem {
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1); // add 1 to the arraylist
        while (result.size() < n) { // continue until arraylist size is n
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i : result) { // for each number in the arraylist
                if (i * 2 - 1 <= n) { // if 2i - 1 is less than or equal to n
                    temp.add(i * 2 - 1); // add 2i - 1 to temp arraylist
                }
            }
            for (int i : result) { // for each number in the arraylist
                if (i * 2 <= n) { // if 2i is less than or equal to n
                    temp.add(i * 2); // add 2i to temp arraylist
                }
            }
            result = temp; // update result to be temp
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = beautifulArray(5);
        System.out.println(list);
    }
}

