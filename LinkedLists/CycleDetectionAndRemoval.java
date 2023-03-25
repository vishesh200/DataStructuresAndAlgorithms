package LinkedLists;

public class CycleDetectionAndRemoval {
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

    public static boolean isCyclic() {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true; // Cycle exists
            }
        }
        return false;
    }
    public static void main(String[] args) {
        CycleDetectionAndRemoval a = new CycleDetectionAndRemoval();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;  // 1 -> 2 -> 3 -> 1
        System.out.println(isCyclic());
    }
}
