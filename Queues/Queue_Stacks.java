package Queues;

import java.util.Stack;

public class Queue_Stacks {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public static boolean isEmpty() {
        return s1.isEmpty();
    }

    // Enqueue : O(n) time complexity we have 2 while loops with O(n) complexity each
    public static void enqueue(int data) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(data);
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public static int dequeue() {
        if(s1.isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return s1.pop();
    }

    public static int peek() {
        if(s1.isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return s1.peek();
    }

    public static void main(String[] args) {
        enqueue(1);
        enqueue(2);
        enqueue(3);
        while(!isEmpty()) {
            System.out.println(peek());
            dequeue();
        }
    }
}
