package LinkedLists;

public class MergeSortForLinkedList {
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

    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public static Node mergeSort(Node head) {
        // Base Case
        if(head == null || head.next == null) {
            return head;
        }

        // Getting the middle point of the Linked List
        Node midNode = findMid(head);

        // Dividing the Linked List into two halves i.e. left and right
        Node rightHead = midNode.next;
        midNode.next = null;

        // Recursive calls
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merging the two sorted halves to get a sorted list
        return merge(newLeft,newRight);
    }

    public static void main(String[] args) {
        head = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(2);
        printLL();
        head = mergeSort(head);
        printLL();
    }
}
