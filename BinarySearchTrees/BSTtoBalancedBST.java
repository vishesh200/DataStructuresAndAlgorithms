package BinarySearchTrees;
import java.util.*;

public class BSTtoBalancedBST {
    static class Node {
        Node left, right;
        int data;
        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root == null) {
            return;
        }
        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right,inorder);
    }

    static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    static Node createBST(ArrayList<Integer> inorder, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder,start,mid-1);
        root.right = createBST(inorder,mid+1,end);
        return root;
    }

    static Node balanceBST(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root,inorder);

        root = createBST(inorder,0,inorder.size()-1);
        return root;
    }


    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        balanceBST(root);
        preorder(root);
    }
}
