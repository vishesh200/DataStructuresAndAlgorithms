package BinarySearchTrees;

import java.util.ArrayList;

public class MergeTwoBSTs {
    static class Node {
        Node left, right;
        int data;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    static Node createBST(ArrayList<Integer> arr, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr,start,mid-1);
        root.right = createBST(arr,mid+1,end);
        return root;
    }

    static void getInorder(Node root,ArrayList<Integer> inorder) {
        if(root == null) {
            return;
        }
        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right,inorder);
    }

    // Time complexity for below function is O(n+m) where n and m are sizes of the two BSTs
    static Node mergeBSTs(Node root1, Node root2) {
        // Getting the sorted inorder sequence in an ArrayList for 1st BST
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        // Getting the sorted inorder sequence in an ArrayList for 2nd BST
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // Merge step
        int i = 0,j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i < arr1.size() && j < arr2.size()) {
            if(arr1.get(i) < arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while(i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }

        while(j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }
        return createBST(finalArr,0,finalArr.size()-1);
    }

    public static void main(String[] args) {
        // Creation of BST1
        Node root1 = new Node(9);
        root1.left = new Node(3);
        root1.right = new Node(12);

        // Creation of BST2
        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(4);

        preorder(root1);
        System.out.println();

        preorder(root2);
        System.out.println();

        Node newRoot = mergeBSTs(root1,root2);
        preorder(newRoot);
    }
}
