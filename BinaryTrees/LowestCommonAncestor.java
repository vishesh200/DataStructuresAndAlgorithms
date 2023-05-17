package BinaryTrees;

import java.util.ArrayList;

public class LowestCommonAncestor {
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

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }

        path.add(root);

        if(root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left,n,path);
        boolean foundRight = getPath(root.right,n,path);

        if(foundLeft || foundRight) {
            return true;
        }

        // Wrong node was getting explored so remove it from the ArrayList
        path.remove(path.size()-1);
        return false;
    }

    // O(n) time complexity as well as O(n) space complexity
    public static Node lca(Node root,int n1,int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        int i=0;
        while(i < path1.size() && i < path2.size()) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
            i++;
        }
        return path1.get(i-1);
    }

    // Here also time complexity is O(n) and Space Complexity is O(1) (Without considering stack space for recursion)
    public static Node lca2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLca = lca2(root.left,n1,n2);
        Node rightLca = lca2(root.right,n1,n2);

        if(rightLca == null) {
            return leftLca;
        }
        if(leftLca == null) {
            return rightLca;
        }
        return root;
    }

    public static int lcaDist(Node root, int n) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left,n);
        int rightDist = lcaDist(root.right,n);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        } else if(leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root,n1,n2);
        int dist1 = lcaDist(lca,n1);
        int dist2 = lcaDist(lca,n2);

        return dist1 + dist2;
    }

    public static void main(String[] args) {
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);
        System.out.println(lca(root2,4,7).data);
        System.out.println(lca2(root2,4,7).data);
        System.out.println(minDist(root2,4,7));
    }
}
