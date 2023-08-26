package BinarySearchTrees;

import java.util.ArrayList;
import java.util.Scanner;

public class KthSmallestElementInABST {
    static class Node {
        Node left, right;
        int data;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void getInorder(ArrayList<Integer> arr, Node root) {
        if(root == null) {
            return;
        }
        getInorder(arr,root.left);
        arr.add(root.data);
        getInorder(arr,root.right);
    }

    static int kthSmallestInABST(Node root,int k) {
        int answer;
        if(root == null) {
            System.out.println("Empty Tree!");
            return -1;
        } else if (k <= 0) {
            System.out.println("Invalid K value!");
            return -1;
        } else {
            ArrayList<Integer> sortedList = new ArrayList<>();
            getInorder(sortedList,root);

            if(k > sortedList.size() - 1) {
                System.out.println("K value greater than the total nodes of the tree!");
                return -1;
            }
            System.out.println(sortedList);
            answer = sortedList.get(k-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);

        System.out.print("Enter the k value : ");
        int k = sc.nextInt();
        System.out.println("The kth smallest value in the BST with k as "+k+" is : "+kthSmallestInABST(root,k));
    }
}

