package BinaryTrees;

/* We have a binary tree, find all duplicate subtrees.
For each duplicate subtree, we only need to return the root node of any one of them.
Two trees are duplicates if they have the same structure with the same node values. */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class DuplicateSubtreesFinder {
    private Map<String, Integer> subtreesMap;
    private List<TreeNode> duplicates;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subtreesMap = new HashMap<>();
        duplicates = new ArrayList<>();
        serializeSubtrees(root);
        return duplicates;
    }

    private String serializeSubtrees(TreeNode node) {
        if (node == null) {
            return "#";
        }

        String serialized = node.val + "," + serializeSubtrees(node.left) + "," + serializeSubtrees(node.right);
        subtreesMap.put(serialized, subtreesMap.getOrDefault(serialized, 0) + 1);

        if (subtreesMap.get(serialized) == 2) {
            duplicates.add(node);
        }

        return serialized;
    }
}

public class DuplicateSubtrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);

        DuplicateSubtreesFinder finder = new DuplicateSubtreesFinder();
        List<TreeNode> duplicates = finder.findDuplicateSubtrees(root);

        System.out.println("Duplicate Subtrees:");
        for (TreeNode duplicate : duplicates) {
            System.out.println(duplicate.val);
        }
    }
}
