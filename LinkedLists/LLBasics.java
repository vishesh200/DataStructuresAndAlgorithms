package LinkedLists;

public class LLBasics {
    // Creation of a single node of the Linked List
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Declaration of head and tail reference variables for the Linked List
    public static Node head; // Points to the starting node of the LL
    public static Node tail; // Points to the ending node of the LL
    public static int size; // Size of the Linked List

    //Method for adding a new node at the beginning of the Linked List
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        // If the LL was initially empty, initialize the head and tail variables to the new node
        if(head == null) {
            head = tail = newNode;
            return;
        }
        // Next variable of the new node should now point to the previously first element i.e. head
        newNode.next = head;
        // Head should now change its value to the new node added at the front
        head = newNode;
    }

    // Method for adding a node at the ending of the Linked List
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Method for adding a node at a particular index
    public void addAtIndex(int index, int data) {
        Node newNode = new Node(data);
        size++;
        if(index == 0) {
            addFirst(data);
            return;
        }
        Node temp = head;
        int i = 0;
        while(i < index-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Method to remove the first node of the LL
    public int removeFirst() {
        if(size == 0) {
            System.out.println("Linked List is already empty!");
            return Integer.MIN_VALUE;
        }
        else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return  val;
        }
        int val = head.data;
        size--;
        head = head.next;
        return val;
    }

    //Method for removing the last node of the LL
    public int removeLast() {
        if(size == 0) {
            System.out.println("Linked List is already empty!");
            return Integer.MIN_VALUE;
        }
        else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return  val;
        }
        Node prev = head;
        for(int i=0; i < size-2; i++) {
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Method for removing the node at a particular index
    public int removeAtIndex(int index) {
        if(size == 0) {
            System.out.println("Linked List is already empty!");
            return Integer.MIN_VALUE;
        }
        else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return  val;
        }
        Node temp = head;
        for(int i=0; i < index-1; i++) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        temp.next.next = null;
        size--;
        return val;
    }

    // Method for printing the Linked List
    public void printLL() {
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

    // Method to search for a key in the Linked List iteratively
    public int iterativeSearch(int key) {
        if (size == 0) {
            System.out.println("Linked List is Empty!");
            return -1;
        }
        int i = 0;
        Node temp = head;
        while(i < size) {
            if(temp.data == key) {
                System.out.println("Key Found at index: "+i);
                return i;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("Key doesn't exist in the given LinkedList.");
        return -1;
    }

    // Recursive Search Method for searching a key
    public int recursiveSearch(Node head,int key,int i) {
        if(head == null) {
            System.out.println("Key Not Found!");
            return -1;
        }
        else if(head.data == key) {
            System.out.println("Key found at index: "+i);
            return i;
        }
        return recursiveSearch(head.next,key,i+1);
    }

    // Reversing the Linked List
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //Deleting Nth node from the end
    public void deleteNthfromTheEnd(int n) {
        // Calculating the size first
        int size = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        if(n == size) {
            head = head.next; // Equivalent to remove first operation
            return;
        }
        // Nth from the end means (size-N)th from the beginning
        int i = 1;
        while(i < size - n) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return;
    }

    // Method for calculating the middle node of the LinkedList
    public static Node findMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Method to check if a Linked List is palindrome or not
    public static boolean isPalindrome() {
        // Checking corner cases
        if(head == null || head.next == null) {
            return true;
        }

        // Finding the middle of the Linked List first
        Node midNode = findMiddleNode(head);

        // Applying the LL reversal logic here as it is
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Assigning pointers to traverse the LL from opposite ends simultaneously
        Node left = head;
        Node right = prev;

        // Comparing the pointers from the left and right
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LLBasics ll = new LLBasics();
        ll.addFirst(1);
        ll.addFirst(0);
        ll.addLast(1);
        ll.addLast(0);
        ll.deleteNthfromTheEnd(4);
        ll.printLL();
        System.out.println("Size of the Linked List is: "+size);
        System.out.println(isPalindrome());
    }
}
