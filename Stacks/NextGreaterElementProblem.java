package Stacks;
import java.util.Stack;

// For every element we need to find the element which is greater than it and as close to it as possible

/* If asked for :
Next Greater from Left : Just reverse the loop given below
Next Smaller from left: Reverse the loop and the condition :  arr[s.peek()] <= arr[i]
Next Smaller from Right: Reverse the condition : arr[s.peek()] <= arr[i]
 */

public class NextGreaterElementProblem {
    public static void main(String[] args) {
        int[] arr = {5,6,8,2,0,1,4};
        Stack<Integer> s = new Stack<>();
        int[] nextGreater = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }

        for(int i=0; i<nextGreater.length; i++) {
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();
    }
}
