package LinkedLists;

public class IntersectingLinkedListsProblem {
    public static Node head;
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printLL(Node head) {
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

    public static Node findIntersectionPoint(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            System.out.println("Intersection not possible.");
            return null;
        }
        if(head1.next == null && head2.next == null) {
            System.out.println("Both Linked lists have only 1 node so intersection not possible.");
            return null;
        }
        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1 != null && temp2 != null) {
            if(temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }


    public static void main(String[] args) {
        // LL1
        Node head1 = head;
        head1 = new Node(1);
        Node node2 = new Node(2);
        head1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(4);
        node3.next = node4;
        printLL(head1); // 1 -> 2 -> 3 -> 4 -> null

        // LL2
        Node head2 = head;
        head2 = new Node(5);
        Node node5 = new Node(6);
        head2.next = node5;
        node5.next = node3;
        printLL(head2); // 5 -> 6 -> 3 -> 4 -> null

        Node intersection = findIntersectionPoint(head1,head2);
        if(intersection == null) {
            System.out.println("The given Linked Lists do not intersect.");
        }
        System.out.println("Both the Linked Lists intersect at a node containing the data: "+intersection.data);
    }
}
