package BinarySearchTrees;

import java.util.*;

public class ClosestElementInBST {
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

    static int closestElementInBST(Node root, int target) {
        if(root == null) {
            System.out.println("Empty Tree!");
            return -1;
        }

        int answerNode = 0;

        ArrayList<Integer> sortedSeq = new ArrayList<>();
        HashMap<Integer,Integer> differenceMap = new HashMap<>();

        getInorder(sortedSeq,root);

        /* We know that for the minimum possible absolute difference,
         maximum possible value must be subtracted from a value */

        for (int i = sortedSeq.size() - 1; i >= 0; i--) {
            int diff = Math.abs(target - sortedSeq.get(i));
            if(diff == 0) {
                return sortedSeq.get(i);
            } else {
                differenceMap.put(sortedSeq.get(i), diff);
            }
        }
        // Creating a HashMap by taking data of a node as the key and its absolute difference with the target as the value
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(differenceMap.entrySet());

        entryList.sort(Map.Entry.comparingByValue());

        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        answerNode = sortedMap.keySet().iterator().next();

        return answerNode;
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the target value : ");
        int targetValue = sc.nextInt();
        System.out.println("The node with least possible absolute difference with the integer target has a value of : "+closestElementInBST(root,targetValue));
    }
}
