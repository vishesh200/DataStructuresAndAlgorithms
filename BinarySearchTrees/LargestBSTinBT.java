package BinarySearchTrees;

public class LargestBSTinBT {
    static int maxBSTSize = 0;
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class Info {
        int min, max, size;
        boolean isBST;
        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static boolean isValidBST(Node root) {
        if(root == null) {
            return true;
        }
        if(root.data < root.left.data || root.data > root.right.data) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    static Info largestBSTInBT(Node root) {
        if(root == null) {
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo = largestBSTInBT(root.left);
        Info rightInfo = largestBSTInBT(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false,size,min,max);
        }
        if(leftInfo.isBST & rightInfo.isBST) {
            maxBSTSize = Math.max(maxBSTSize, size);
            return new Info(true,size,min,max);
        }
        return new Info(false,size,min,max);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        Info info = largestBSTInBT(root);
        System.out.println("Size of largest possible BST is : "+maxBSTSize);
    }
}
