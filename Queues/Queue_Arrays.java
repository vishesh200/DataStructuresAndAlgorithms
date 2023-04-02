/* Basic Queue implementation using Arrays but here time complexity for
dequeue operation is O(n) as all the elements after the removed element
need to shifted backwards after each each dequeue operation in order to
override and hence remove the element from the queue and here there is
memory wastage as once rear has reached to (size-1)th index then even
after dequeueing you cannot add more elements into the queue. Except
dequeue, both the other operations have O(1) time complexity */

package Queues;

class Queue {
    static int[] arr;
    static int size;
    static int rear;

    Queue(int n) {
        arr = new int[n];
        size = n;
        rear = -1;
    }

    public static boolean isEmpty() {
        return rear == -1;
    }

    public static boolean isFull() {
        return rear == size - 1;
    }

    public static void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full!");
            return;
        }
        rear += 1;
        arr[rear] = data;
    }

    public static int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        int front = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear -= 1;
        return front;
    }

    public static int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return arr[0];
    }
}

public class Queue_Arrays {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            Queue.dequeue();
        }
    }
}
