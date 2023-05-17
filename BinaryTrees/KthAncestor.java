package BinaryTrees;

public class KthAncestor {
    static class Node {
        private int data;
        private Node left;
        private Node right;
        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public static int kthAncestor(Node root, int n, int k) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDist = kthAncestor(root.left,n,k);
        int rightDist = kthAncestor(root.right,n,k);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist,rightDist);

        if(max + 1 == k) {
            System.out.println(root.data);
        }

        return max+1;
    }
    public static void main(String[] args) {
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);
        kthAncestor(root2,5,2);
    }
}
