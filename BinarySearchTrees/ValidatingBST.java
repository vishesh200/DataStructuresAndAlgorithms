package BinarySearchTrees;

public class ValidatingBST {
    static class Node {
        Node left, right;
        int data;
        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && max.data <= root.data) {
            return false;
        }
        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }

    static Node buildBST(int value, Node root) {
        if(root == null) {
            root = new Node(value);
            return root;
        }

        if (root.data > value) {
            root.left = buildBST(value,root.left);
        } else {
            root.right = buildBST(value,root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] values = {8,5,3,6,10,11,14};
        Node root = null;
        for (int val: values) {
            root = buildBST(val,root);
        }
        System.out.println(isValidBST(root,null,null));
    }
}
