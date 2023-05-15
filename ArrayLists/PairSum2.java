package ArrayLists;
import java.util.ArrayList;

/* We've been given a rotated and sorted ArrayList and we
need to find a pair of values in the ArrayList such that its
sum is equal to a predefined target */

/* Firstly we'll find the breaking point which means the index after which
values are not in the originally ascending order
Ex:  list = [6,7,1,2,3,4] so breaking point = 7

Next we are going to implement the left and right pointers in such a way that
whenever they reach to a point after which they are going to go index out of bounds
then they again point to the opposite end of the list in a circular fashion by means
of modular arithmetic i.e.
leftPointer = (leftPointer + 1) % n
rightPointer = (rightPointer + n - 1) % n
where n = list.size()
 */

public class PairSum2 {
    // Same 2 pointer approach with O(n) time complexity will be followed
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int n = list.size();
        int breakingPoint = -1;
        for(int i=0; i<n; i++) {
            if(list.get(i) > list.get(i+1)) {
                breakingPoint = i;
                break;
            }
        }
        int leftPointer = breakingPoint + 1;
        int rightPointer = breakingPoint;

        while(leftPointer != rightPointer) {
            if(list.get(leftPointer) + list.get(rightPointer) == target) {
                return true;
            }
            else if(list.get(leftPointer) + list.get(rightPointer) < target) {
                leftPointer = (leftPointer+1) % n;
            }
            else {
                rightPointer = (rightPointer+n-1) % n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(pairSum2(list, 9));
        System.out.println(pairSum2(list, 12));
    }
}
