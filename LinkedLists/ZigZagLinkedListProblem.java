package LinkedLists;

public class ZigZagLinkedListProblem {
    public static Node head;
    public static Node tail;
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printLL() {
        if(head == null) {
            System.out.println("Linked List is Empty!");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void zigZag()  {
        // Finding the midpoint of the list
        Node slow = head;
        Node fast = head.next;

        while(fast != null &&  fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        // Linked List Reversal Code
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        /* Assigning the pointers corresponding values to traverse the Linked List from both ends simultaneously
        in order to arrange it in a zig-zag fashion */
        Node right = prev;
        Node left = head;
        Node nextLeft, nextRight;

        // ZigZag code
        while(left != null && right != null) {
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printLL();
        zigZag();
        printLL();
    }
}
