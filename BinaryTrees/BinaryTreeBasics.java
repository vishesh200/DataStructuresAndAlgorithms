package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBasics {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;
    public static Node buildTree(int[] nodes) {
        idx++;
        if(nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelOrder(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add(null);

        while(!nodes.isEmpty()) {
            Node currNode = nodes.remove();
            if(currNode == null) {
                System.out.println();
                if(nodes.isEmpty()) {
                    break;
                } else {
                    nodes.add(null);
                }
            } else {
                System.out.print(currNode.data+" ");
                if(currNode.left != null) {
                    nodes.add(currNode.left);
                }
                if(currNode.right != null) {
                    nodes.add(currNode.right);
                }
            }
        }
    }

    public static int calcHeight(Node root) {
        if(root == null) {
            return 0;
        }

        int left = calcHeight(root.left);
        int right = calcHeight(root.right);
        return Math.max(left,right) + 1;
    }

    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int left_count = countNodes(root.left);
        int right_count = countNodes(root.right);
        return left_count+right_count+1;
    }

    public static int sumOfNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int left_sum = sumOfNodes(root.left);
        int right_sum = sumOfNodes(root.right);
        return left_sum+right_sum+root.data;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildTree(nodes);
        System.out.println(root.data);
        System.out.println();

        preOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);
        System.out.println("Height of the tree is : "+calcHeight(root2));
        System.out.println("Total number of nodes in the tree is : "+countNodes(root2));
        System.out.println("Sum of nodes of the tree is : "+sumOfNodes(root2));
    }
}
