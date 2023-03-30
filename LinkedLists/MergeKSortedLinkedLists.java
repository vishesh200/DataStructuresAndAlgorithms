package LinkedLists;

// We have K sorted linked lists of size N each, merge them and print the sorted output.
public class MergeKSortedLinkedLists {
    public static Node head;

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        int k = lists.length;
        Node mergedList = new Node(-1);
        Node head = mergedList;
        Node[] currentNodes = new Node[k]; // Contains the head of each linked list at each index
        for (int i = 0; i < k; i++) {
            currentNodes[i] = lists[i];
        }
        while (true) {
            int minVal = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int i = 0; i < k; i++) {
                if (currentNodes[i] != null && currentNodes[i].data < minVal) {
                    minVal = currentNodes[i].data;
                    minIdx = i;
                }
            }
            if (minIdx == -1) {
                break;
            }
            mergedList.next = new Node(minVal);
            mergedList = mergedList.next;
            currentNodes[minIdx] = currentNodes[minIdx].next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(4);
        l1.next.next = new Node(5);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);

        Node l3 = new Node(2);
        l3.next = new Node(6);

        Node[] lists = {l1, l2, l3};

        Node mergedList = mergeKLists(lists);

        while (mergedList != null) {
            System.out.print(mergedList.data + " ");
            mergedList = mergedList.next;
        }
    }
}
