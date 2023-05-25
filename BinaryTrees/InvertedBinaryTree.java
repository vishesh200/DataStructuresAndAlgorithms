package BinaryTrees;

class Node1 {
     int data;
     Node1 left;
     Node1 right;

    public Node1(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node1 root;

    public void mirror() {
        mirrorHelper(root);
    }

    private void mirrorHelper(Node1 node) {
        if (node == null) {
            return;
        }

        // Swap the left and right children of the current node
        Node1 temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recursively mirror the left and right subtrees
        mirrorHelper(node.left);
        mirrorHelper(node.right);
    }

    public void inOrderTraversal(Node1 node) {
        if (node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }
}

public class InvertedBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node1(1);
        tree.root.left = new Node1(2);
        tree.root.right = new Node1(3);
        tree.root.left.left = new Node1(4);
        tree.root.left.right = new Node1(5);

        System.out.println("Original tree:");
        tree.inOrderTraversal(tree.root);

        tree.mirror();

        System.out.println("\nMirrored tree:");
        tree.inOrderTraversal(tree.root);
    }
}
