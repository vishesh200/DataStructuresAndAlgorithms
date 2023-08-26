package BinarySearchTrees;

import java.util.ArrayList;
import java.util.Scanner;

public class RangeSumOfBST {
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

    static int rangeSumOfBST(Node root, int r1, int r2) {
        int sum = 0;

        if(r1 <= 0 || r2 <= 0) {
            System.out.println("The given values of r1 : "+r1+" and r2 : "+r2+" are not positive.");
            return -1;
        }

        ArrayList<Integer> inorderSeq = new ArrayList<>();

        getInorder(inorderSeq,root);

        if(inorderSeq.size() == 0) {
            return 0;
        }

        int left = 0;
        int right = inorderSeq.size() - 1;

        while(inorderSeq.get(left) < r1 || inorderSeq.get(right) > r2) {
            if(inorderSeq.get(left) < r1) {
                left++;
            }
            if(inorderSeq.get(right) > r2) {
                right--;
            }
        }

        for(int i = left; i <= right; i++) {
            sum += inorderSeq.get(i);
        }


        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);

        System.out.print("Enter the first range value : ");
        int r1 = sc.nextInt();

        System.out.print("Enter the second range value : ");
        int r2 = sc.nextInt();

        int rangeSum = rangeSumOfBST(root,r1,r2);

        System.out.println("The sum of values between "+r1+" and "+r2+" in the given BST is : "+rangeSum);
    }
}



