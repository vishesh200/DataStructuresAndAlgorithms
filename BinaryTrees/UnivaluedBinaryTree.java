package BinaryTrees;

/* We have a binary tree, the task is to check if the binary tree is univalued (all nodes have the same data) or not.
If found to be true, then print “YES”. Otherwise, print “NO”. */

import static java.lang.System.exit;

public class UnivaluedBinaryTree {
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

    public static boolean isUnivalued(Node root) {
        if(root == null) {
            return true;
        }

        if(root.left != null && root.data != root.left.data) {
            return false;
        }

        if(root.right != null && root.data != root.right.data) {
            return false;
        }

        return (isUnivalued(root.left) && isUnivalued(root.right));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(2);
        root.left.right = new Node(2);

        System.out.println(isUnivalued(root));
    }
}
