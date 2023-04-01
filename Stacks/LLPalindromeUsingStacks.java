package Stacks;
import java.util.Stack;

public class LLPalindromeUsingStacks {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;

    public static boolean isPalindrome(Node head) {
        Stack<Integer> s = new Stack<>();
        Node temp = head;
        while(temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }
        while(head != null) {
            if(s.pop() != head.data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        System.out.println(isPalindrome(head));
    }
}
