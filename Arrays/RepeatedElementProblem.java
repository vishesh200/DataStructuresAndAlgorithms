package Arrays;

import java.util.Arrays;

public class RepeatedElementProblem {
    public static boolean isRepeated(int[] arr) {
        int l = arr.length;
        Arrays.sort(arr);
        int difference = 0;
        if (l == 0 || l == 1) {
            return false;
        }
        for (int i = 1; i < l; i++) {
            difference = arr[i] - arr[i - 1];
            if (difference == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,7,9,8};
        System.out.println(isRepeated(arr));
    }
}