package BinaryTrees;

public class SumTree {
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
    public static int transform(Node root) {
        if(root == null) {
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;

        int newLeft = (root.left == null) ? 0 : root.left.data;
        int newRight = (root.right == null) ? 0 : root.right.data;

        root.data = leftChild + newLeft + rightChild + newRight;

        return data;
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);

        transform(root2);
        preOrder(root2);
    }
}
