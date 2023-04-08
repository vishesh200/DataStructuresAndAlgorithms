package Queues;
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeUsage {
    static class Queue {
        Deque<Integer> Q = new ArrayDeque<>();
        public void enqueue(int data) {
            Q.addLast(data);
        }

        public int dequeue() {
            if(Q.isEmpty()) {
                System.out.println("Queue is Empty!");
                return Integer.MIN_VALUE;
            }
            return Q.removeFirst();
        }

        public int peek() {
            if(Q.isEmpty()) {
                System.out.println("Queue is Empty!");
                return Integer.MIN_VALUE;
            }
            return Q.getFirst();
        }
    }

    static class Stack {
        Deque<Integer> S = new ArrayDeque<>();

        public void push(int data) {
            S.addLast(data);
        }

        public int pop() {
            if(S.isEmpty()) {
                System.out.println("Stack is Empty!");
                return Integer.MIN_VALUE;
            }
            return S.removeLast();
        }

        public int peek() {
            if(S.isEmpty()) {
                System.out.println("Stack is Empty!");
                return Integer.MIN_VALUE;
            }
            return S.getLast();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        Stack s = new Stack();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
