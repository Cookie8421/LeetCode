package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest. You may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 *
 * Example 2:
 *
 * Input: root = [1,2,4,null,3], to_delete = [3]
 * Output: [[1,2,4]]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the given tree is at most 1000.
 *     Each node has a distinct value between 1 and 1000.
 *     to_delete.length <= 1000
 *     to_delete contains distinct values between 1 and 1000.
 */
public class DeleteNodesAndReturnForest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<TreeNode> forest = new ArrayList<>();
    List<Integer> toDelete = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        /**
         * Runtime: 5 ms, faster than 15.84% of Java online submissions for Delete Nodes And Return Forest.
         * Memory Usage: 48.3 MB, less than 19.81% of Java online submissions for Delete Nodes And Return Forest.
         */
        for(int i = 0; i < to_delete.length; i++){
            toDelete.add(to_delete[i]);
        }
        forest.add(root);
        dfs(root);
        return forest;
    }

    private boolean dfs(TreeNode root){
        if(root == null){
            return false;
        }
        if(!dfs(root.left)){
            root.left = null;
        }
        if(!dfs(root.right)){
            root.right = null;
        }
        if(toDelete.contains(root.val)){
            if(forest.contains(root)){
                forest.remove(root);
            }
            if(root.left != null){
                forest.add(root.left);
            }
            if(root.right != null){
                forest.add(root.right);
            }
            toDelete.remove(new Integer(root.val));
            return false;
        } else {
            return true;
        }
    }


    /**
     Runtime: 3 ms, faster than 70.52% of Java online submissions for Delete Nodes And Return Forest.
     Memory Usage: 48.2 MB, less than 36.10% of Java online submissions for Delete Nodes And Return Forest.
     **/
    /*
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> forest = new ArrayList<>();
        if (root == null) return forest;
        Set<Integer> set = new HashSet<>();
        for(int i : to_delete) {
            set.add(i);
        }
        deleteNodes(root, set, forest);
        if (!set.contains(root.val)) {
            forest.add(root);
        }

        return forest;
    }

    private TreeNode deleteNodes(TreeNode node, Set<Integer> set, List<TreeNode> forest) {
        if (node == null) return null;

        node.left = deleteNodes(node.left, set, forest);
        node.right = deleteNodes(node.right, set, forest);

        if (set.contains(node.val)) {
            if (node.left != null) forest.add(node.left);
            if (node.right != null) forest.add(node.right);
            return null;
        }

        return node;
    }
     */
}
