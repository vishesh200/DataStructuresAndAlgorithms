/*
We've been given an integer n, and we need to display all
the binary numbers corresponding to the decimal numbers from
1 till n.
 */

package Queues;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbersProblem {
    public static void generateBinaryNumbers(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n-- > 0) {
            String s1 = q.peek();
            q.remove();
            System.out.println(s1);
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");
        }
    }
    public static void main(String[] args) {
        int n = 5;
        generateBinaryNumbers(n);
    }
}
