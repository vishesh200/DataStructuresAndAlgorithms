/* Here we'll have an optimised implementation of Queue using arrays by having
a circular queue as we'll implement front pointer as front = (front+1) % size
and rear = (rear + 1) % size which will stop rearrangement of array after each
dequeue operation and will also be memory efficient as we can enqueue even after
rear pointer has reached the (size - 1)th index due to the queue's circular
nature. All the operations here have O(1) time complexity. */

package Queues;

class CircularQueue {
    static int[] arr;
    static int size;
    static int rear;
    static int front;

    CircularQueue(int n) {
        arr = new int[n];
        rear = front = -1;
        size = n;
    }

    public static boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    public static boolean isFull() {
        return ((rear + 1) % size == front);
    }

    public static void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue full");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    public static int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        int val = arr[front];
        if (front == rear) {
            rear = front = -1;
        } else {
            front = (front + 1) % size;
        }
        return val;
    }

    public static int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return arr[front];
    }
}

public class QueueOptimised_Arrays {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.dequeue();
        }
    }
}
