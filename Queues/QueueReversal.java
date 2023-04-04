/* Here we have to reverse the Queue using any suitable data
structure. So we use Stack due to its LIFO property which is most
appropriate for this problem. Here we have O(n) time and space
complexity as we have a created a Stack for reversing our elements */

package Queues;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {
    public static void reverse(Queue<Integer> q) {
        if(q.size() == 0 || q.size() == 1) {
            return;
        }
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()) {
            s.push(q.remove());
        }
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q);
        reverse(q);
        System.out.println(q);
    }
}
