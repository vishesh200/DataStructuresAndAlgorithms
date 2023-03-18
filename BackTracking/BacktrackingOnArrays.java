package BackTracking;
/* Assign values initially as 1,2,3,4,5 in an array of size 5
and during backtracking step decrement 2 from each value present in the
array
 */
public class BacktrackingOnArrays {
    public static void printArrays(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static void updateValues(int[] arr,int index) {
        if(index == arr.length) {
            printArrays(arr);
            return;
        }
        arr[index] = index+1;
        updateValues(arr,index+1); // recursive step
        arr[index] -= 2; // backtracking step
    }
    public static void main(String[] args) {
        int[] arr = new int[5];
        updateValues(arr,0);
        printArrays(arr);
    }
}
