/*
ArrayList is internally implemented using Arrays only.
Whenever an array gets full, Java automatically doubles its size
which makes it a dynamically allocated array
 */
package ArrayLists;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListBasics {
    public static void swap(ArrayList<Integer> list,int idx1,int idx2) {
        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=5; i++) {
            list.add(i); // Add operation --> O(1) time complexity
        }
        System.out.println(list);

        // Get operation --> O(1) time complexity
        int value = list.get(3);
        System.out.println("Value at index 3 is: "+value);

        /* Remove operation
        --> O(n) time complexity as it involves linear searching and memory reallocation
         */
        list.remove(2);
        System.out.println(list);

        /* Set operation (sets a value at a particular index by
        overwriting the existing value)
        --> O(n) time complexity
         */
        list.set(2,100);
        System.out.println(list);

        //Contains Element operation (returns a boolean) --> O(n) time complexity
        System.out.println(list.contains(64));
        System.out.println(list.contains(100));

        // Alternative add syntax
        /* Adds 55 at index 1 and
        pushes the element present
        originally at 1 back by one index
         */
        list.add(1,55);
        System.out.println(list);

        //Size of an ArrayList
        System.out.println(list.size());

        //Iterating an ArrayList by using .size and .get function
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //Printing the reverse of an ArrayList
        for(int i=list.size()-1; i>=0; i--) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        
        //Getting the maximum value out of an ArrayList
        int max = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++) {
            int current = list.get(i);
            if(current > max) {
                max = current;
            }
        }
        System.out.println("Maximum element of the ArrayList is: "+max);

        // Swap functionality on ArrayLists by creating a user defined swap function
        int idx1 = 1, idx2 = 3;
        System.out.println("List before swapping: ");
        System.out.println(list);
        swap(list,idx1,idx2);
        System.out.println("List after swapping: ");
        System.out.println(list);

        // Sorting an ArrayList

        // Sorts the list in an ascending order
        Collections.sort(list);
        System.out.println(list);
        // Descending order Sorting
        Collections.sort(list,Collections.reverseOrder()); // reverseOrder is a Java Comparator
        System.out.println(list);

        // Multidimensional ArrayLists
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for(int i=1; i<=5; i++) {
            list1.add(i); // Adds 1 2 3 4 5 to list1
            list2.add(i*2); // Adds 2 4 6 8 10 to list2
            list3.add(i*3); // Adds 3 6 9 12 15 to list3
        }
        // Adding sublists to the main list
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        // Printing out the ArrayList of ArrayLists
        System.out.println(mainList);

        // Printing individual ArrayLists using nested loops
        for(int i=0; i<mainList.size(); i++) {
            ArrayList<Integer> currentList = mainList.get(i);
            for(int j=0; j<currentList.size(); j++) {
                System.out.print(currentList.get(j)+" ");
            }
            System.out.println();
        }
    }
}
