/* Most time saving and optimised way of Queue implementation using
predefined functions and classes available in Java Collections Framework.
Queue is an interface in Java while a queue can be instantiated using a
Linked List or an ArrayDeque class. */

/* ArrayDeque is an implementation of Deque interface. This queue implementation
is more efficient one than the LinkedList implementation as it consumes less memory
due to absence of pointers and Linked List structures are difficult to iterate as
compared to ArrayDeque. Also, it provides an additional functionality of deleting
or adding elements from both ends which makes it a flexible option for implementing Queues */

// ArrayDeque is more efficient in adding and removing elements than Linked List

package Queues;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_JCF {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        System.out.println("Queue using Linked List class: ");
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

        System.out.println("Queue using ArrayDeque class: ");
        q2.add(4);
        q2.add(5);
        q2.add(6);
        while(!q2.isEmpty()) {
            System.out.println(q2.peek());
            q2.remove();
        }
    }
}
