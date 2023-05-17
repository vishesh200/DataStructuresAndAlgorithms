package BinaryTrees;

import java.util.HashMap;
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

    // O(n^2) time complexity approach as we have to calculate the height by visiting n nodes and calculating height at each node takes O(n) time.
    public static int diameter(Node root) {
        if(root == null) {
            return 0;
        }
        int left_diam = diameter(root.left); // If the left subtree has a maximum diameter which doesn't involve the root node
        int left_height = calcHeight(root.left);
        int right_diam = diameter(root.right); // If the right subtree has a maximum diameter which doesn't involve the root node
        int right_height = calcHeight(root.right);

        int self_diam = left_height+right_height+1; // The diameter involving the root node

        return Math.max(self_diam, Math.max(left_diam,right_diam));
    }

    static class Info {
        private int ht;
        private int diam;
        Info(int d, int h) {
            diam = d;
            ht = h;
        }
    }

    // O(n) time complexity as we are calculating height and diameter of each node simultaneously
    public static Info optimisedDiameter(Node root) {
        if(root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = optimisedDiameter(root.left);
        Info rightInfo = optimisedDiameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht,rightInfo.ht) + 1;
        return new Info(diam,ht);
    }

    public static boolean isIdentical(Node node, Node subRoot) {
        if(node == null && subRoot == null) {
            return true;
        } else if(node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }
        if(!isIdentical(node.left,subRoot.left)) {
            return false;
        }
        if(!isIdentical(node.right,subRoot.right)) {
            return false;
        }
        return true;
    }

    public static boolean isSubTree(Node root, Node subRoot) {
        if(root == null) {
            return false;
        }
        if(root.data == subRoot.data) {
            if(isIdentical(root,subRoot)) {
                return true;
            }
        }
        return isSubTree(root.left,subRoot) || isSubTree(root.right,subRoot);
    }

    static class NodeInfo {
        private int horiz_dist;
        private Node node;
        NodeInfo(Node n, int dist) {
            node = n;
            horiz_dist = dist;
        }

    }
    public static void topView(Node root) {
        Queue<NodeInfo> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        q.add(new NodeInfo(root,0));
        q.add(null);
        int min = 0, max = 0;

        while(!q.isEmpty()) {
            NodeInfo currNode = q.remove();
            if(currNode == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(!map.containsKey(currNode.horiz_dist)) {
                    map.put(currNode.horiz_dist, currNode.node);
                }
                if(currNode.node.left != null) {
                    q.add(new NodeInfo(currNode.node.left,currNode.horiz_dist-1));
                    min = Math.min(min, currNode.horiz_dist-1);
                }
                if(currNode.node.right != null) {
                    q.add(new NodeInfo(currNode.node.right,currNode.horiz_dist+1));
                    max = Math.max(max, currNode.horiz_dist+1);
                }
            }
        }
        for(int j=min; j<=max; j++) {
            System.out.print(map.get(j).data+" ");
        }
        System.out.println();
    }

    public static void nodesOnkthLevel(Node root, int level, int k) {
        if(root == null) {
            return;
        }

        if(level == k) {
            System.out.print(root.data+" ");
            return;
        }
        nodesOnkthLevel(root.left,level+1,k);
        nodesOnkthLevel(root.right,level+1,k);
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
        inOrder(root);
        System.out.println();

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);

        Node root3 = new Node(2);
        root3.left = new Node(4);
        root3.right = new Node(5);

        System.out.println("Height of the tree is : "+calcHeight(root2));
        System.out.println("Total number of nodes in the tree is : "+countNodes(root2));
        System.out.println("Sum of nodes of the tree is : "+sumOfNodes(root2));
        System.out.println("Diameter of the given tree is : "+diameter(root2));
        System.out.println("Diameter : "+optimisedDiameter(root2).diam);
        System.out.println(isSubTree(root2,root3));
        topView(root2);
        nodesOnkthLevel(root2,1,3);
    }
}
