package BinarySearchTrees;

import java.util.ArrayList;

public class BasicsOfBST {
    static class Node {
        Node left, right;
        int data;
        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public static Node buildBST(int value, Node root) {
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

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    // We do a BFS in searching so Time Complexity of searching in a BST is O(H)
    // Here H is the height of the BST
    // Average Case Complexity : O(log(n)) (Balanced BST)
    // Worst Case Complexity : O(n) (Skewed BST)
    public static boolean searchInBST(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(root.data > key) {
            return searchInBST(root.left, key);
        } else {
            return searchInBST(root.right,key);
        }
    }

    public static Node deleteInBST(Node root, int val) {
        if(root.data > val) {
            root.left = deleteInBST(root.left, val);
        } else if (root.data < val) {
            root.right = deleteInBST(root.right,val);
        } else {
            // Case 1 : Node to be deleted is a leaf node
            if(root.left == null && root.right == null) {
                return null;
            }

            // Case 2 : Node to be deleted has 1 child
            if(root.right == null) {
                return root.left;
            }
            if(root.left == null) {
                return root.right;
            }

            // Case 3 : Node to be deleted has 2 children
            Node inordSucc = findInorderSuccessor(root.right);
            root.data = inordSucc.data;
            root.right = deleteInBST(root.right, inordSucc.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }

        if(k1 <= root.data && root.data <= k2) {
            printInRange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printInRange(root.right,k1,k2);
        }
        else if (root.data < k1) {
            printInRange(root.right,k1,k2);
        } else {
            printInRange(root.left,k1,k2);
        }
    }

    public static void root2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) {
            printPath(path);
        }
        root2Leaf(root.left,path);
        root2Leaf(root.right,path);
        path.remove(path.size()-1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i)+" -> ");
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        int[] values = {8,5,3,6,10,11,14};
        Node root = null;
        for (int val: values) {
            root = buildBST(val,root);
        }
//        inOrder(root);
//        System.out.println();
//
//        //System.out.println(searchInBST(root,3));
//        root = deleteInBST(root,1);
//        inOrder(root);

//        printInRange(root,5,12);
        root2Leaf(root,new ArrayList<>());
    }
}
