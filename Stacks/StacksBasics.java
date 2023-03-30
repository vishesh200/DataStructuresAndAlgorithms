package Stacks;
import java.util.ArrayList;

public class StacksBasics {

    // Stack Implementation using Linked List
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class StackUsingLL {

        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            if(isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            if(isEmpty()) {
                return -1;
            }
            int val = head.data;
            head = head.next;
            return val;
        }

        public static int peek() {
            if(isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }


    // Stack Implementation using ArrayList
    static class Stack {

        public static ArrayList<Integer> list = new ArrayList<>();

        // Checking if the Stack is Empty or not
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // Pushing elements on top of the Stack --> O(1) complexity
        public static void push(int data) {
            list.add(data);
        }

        // Popping Elements from the Stack's top --> O(1) complexity
        public static int pop() {
            if(isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // Peeking the top element --> O(1) complexity
        public static int peek() {
            if(isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
//        Stack.push(1);
//        Stack.push(2);
//        Stack.push(3);
//        while(!Stack.isEmpty()) {
//            System.out.println(Stack.peek());
//            Stack.pop();
//        }

        StackUsingLL.push(4);
        StackUsingLL.push(5);
        StackUsingLL.push(6);
        while(!StackUsingLL.isEmpty()) {
            System.out.println(StackUsingLL.peek());
            StackUsingLL.pop();
        }
    }
}
