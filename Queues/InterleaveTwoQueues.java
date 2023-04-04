/* We've been given a queue having even length, and we need to interleave
its two halves into a single interleaved queue.
Ex : Given queue : q0 ~ [1,2,3,4,5,6],
Two halves : q1 ~ [1,2,3] and q2 ~ [4,5,6]
Answer : Q ~ [1,4,2,5,3,6] */

package Queues;
import java.util.Queue;
import java.util.LinkedList;

/* Solution has both time and space complexities as O(n) as
we have made one extra queue
 */

public class InterleaveTwoQueues {
    public static Queue<Integer> interleave(Queue<Integer> q1) {
        if(q1.size() == 0) {
            return q1;
        }else if((q1.size()) % 2 != 0) {
            System.out.println("Sorry the given queue is of odd length.");
            return q1;
        } else {
            int half = q1.size()/2;
            Queue<Integer> firstHalf = new LinkedList<>();
            for(int i=0; i<half; i++) {
                firstHalf.add(q1.remove());
            }
            while(!firstHalf.isEmpty()) {
                q1.add(firstHalf.remove());
                q1.add(q1.remove());
            }
        }
        return q1;
    }
    public static void main(String[] args) {
        Queue<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        System.out.println(a);
        Queue<Integer> res = interleave(a);
        System.out.println(res);
    }
}
