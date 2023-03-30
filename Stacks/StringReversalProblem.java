package Stacks;
import java.util.Stack;

public class StringReversalProblem {
    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();


        // Push all the characters of the string into the stack one by one
        int idx = 0;
        while(idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder sb = new StringBuilder("");

        // After popping when they retrieved in reverse order then append it into a StringBuilder object
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str);
        String res = reverse(str);
        System.out.println(res);
    }
}
