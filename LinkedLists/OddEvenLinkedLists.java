package LinkedLists;

import java.util.LinkedList;
import java.util.ArrayList;

/*
We have a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list.
Also, keep the order of even and odd numbers same.
 */

public class OddEvenLinkedLists {
    // Classical Approach by creating a Linked List and performing all the operations manually
    public static Node head;

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node segregateEvenOdd(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node odd = null, even = null, oddHead = null, evenHead = null;

        while(head != null) {
            if(head.data % 2 == 0) {
                if(even == null) {
                    even = head;
                    evenHead = head;
                } else {
                    even.next = head;
                    even = even.next;
                }
            } else {
                if(odd == null) {
                    odd = head;
                    oddHead = head;
                } else {
                    odd.next = head;
                    odd = odd.next;
                }
            }
            head = head.next;
        }
        if(even == null) {
            return oddHead;
        }
        even.next = oddHead;
        if(odd != null) {
            odd.next = null;
        }
        return evenHead;
    }

    public static void printList(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Solving the problem by using JCF
    public static LinkedList<Integer> oddEven(LinkedList<Integer> ll) {
        if(ll.size() == 0) {
            return null;
        }

        LinkedList<Integer> answer = new LinkedList<>();
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();

        for(int i=0; i<ll.size(); i++) {
            if((ll.get(i) % 2) == 0) {
                evenList.add(ll.get(i));
            }
            else if ((ll.get(i) % 2) != 0) {
                oddList.add(ll.get(i));
            }
        }

        for(int j=0; j<evenList.size(); j++) {
            answer.addLast(evenList.get(j));
        }

        for(int k=0; k<oddList.size(); k++) {
            answer.addLast(oddList.get(k));
        }

        return answer;
    }


    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(8);
        ll.addLast(12);
        ll.addLast(10);
        ll.addLast(5);
        ll.addLast(4);
        ll.addLast(1);
        ll.addLast(6);
        System.out.println(ll);
        LinkedList<Integer> result = oddEven(ll);
        System.out.println(result);


        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List: ");
        printList(head);

        Node newHead = segregateEvenOdd(head);

        System.out.println("Modified List: ");
        printList(newHead);
    }
}
