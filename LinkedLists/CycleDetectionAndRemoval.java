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

    // Method for removing the cycle in the Linked List
    public static void removeCycle() {
        // Firstly checking if the cycle exists or not
        boolean isCyclic = false;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                isCyclic = true;
                break;
            }
        }
        if(isCyclic == false) {
            return;
        }
        /* Initializing our slow pointer to the head and then moving the slow and fast
        pointers everytime by 1 position to see where they meet next and mathematically
        that happens at the point where linked list forms a cycle so the value of the
        node just before the meeting point will be stored inside prev pointer and its
        next will then be assigned the value of null to remove the cycle */
        slow = head;
        Node prev = null;
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // Removing the cycle
        prev.next = null;
    }
    public static void main(String[] args) {
        CycleDetectionAndRemoval a = new CycleDetectionAndRemoval();
        head = new Node(1);
        head.next = new Node(2);
        Node temp = new Node(3);
        head.next.next = temp;
        temp.next = new Node(4);
        temp.next.next = temp;
        System.out.println(isCyclic());
        removeCycle();
        System.out.println(isCyclic());
    }
}
