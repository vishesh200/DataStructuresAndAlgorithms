/* This is the most optimised way of implementing queues as there is dynamic
memory allocation so no need to check whether queue is full or not as it
theoretically can be of infinite size. Also all the operations are performed
in O(1) time complexity. */

package Queues;

public class Queue_LinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public static boolean isEmpty() {
        return head == null;
    }

    public static void enqueue(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        int val = head.data;
        head = head.next;
        return val;
    }

    public static int peek() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return head.data;
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
