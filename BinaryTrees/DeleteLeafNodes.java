package BinaryTrees;

/* Delete leaf nodes with values as x
We have a binary tree and a target integer x, delete all the leaf nodes having value as x.
Also, delete the newly formed leaves with the target value as x. */

class Node2 {
    int data;
    Node2 left;
    Node2 right;

    public Node2(int data) {
        this.data = data;
        left = right = null;
    }
}

class BTree {
    Node2 root;

    public void delete(int target) {
        root = deleteLeafNodes(root,target);
    }

    private Node2 deleteLeafNodes(Node2 node, int target) {
        if(node == null) {
            return null;
        }

        node.left = deleteLeafNodes(node.left,target);
        node.right = deleteLeafNodes(node.right,target);

        if (node.data == target && node.left == null && node.right == null) {
            return null;
        }
        return node;
    }

    public void inOrder(Node2 node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
}

public class DeleteLeafNodes {
    public static void main(String[] args) {
        BTree b = new BTree();
        b.root = new Node2(1);
        b.root.left = new Node2(3);
        b.root.right = new Node2(3);
        b.root.left.left = new Node2(3);
        b.root.left.right = new Node2(2);

        System.out.println("Before deletion : ");
        b.inOrder(b.root);

        b.delete(3);
        System.out.println();

        System.out.println("After deletion : ");
        b.inOrder(b.root);
    }
}
