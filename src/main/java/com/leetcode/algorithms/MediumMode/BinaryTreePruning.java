package com.leetcode.algorithms.MediumMode;

/**
 * @Author JoeyYoung
 * @ClassName: Binary Tree Pruning
 * @Date 2021/12/2 8:50
 * @Description:
 * Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 *
 * A subtree of a node node is node plus every node that is a descendant of node.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 * Explanation:
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 *
 * Example 2:
 *
 * Input: root = [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 *
 * Example 3:
 *
 * Input: root = [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 200].
 *     Node.val is either 0 or 1.
 *
 */
public class BinaryTreePruning {

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

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Pruning.
     * Memory Usage: 36.9 MB, less than 38.90% of Java online submissions for Binary Tree Pruning.
     */
    public TreeNode pruneTree(TreeNode root) {
        if(trimTree(root)){
            return null;
        }
        return root;
    }

    public static boolean trimTree(TreeNode root) {
        boolean leftFlag = true;
        boolean rightFlag = true;
        if(root.left != null){
            leftFlag = trimTree(root.left);
        }
        if(root.right != null){
            rightFlag = trimTree(root.right);
        }
        if(root.val == 1){
            if(root.left == null && root.right == null){
                return false;
            }
        } else if(root.val == 0){
            if((leftFlag && rightFlag) || (root.left == null && root.right == null)){
                return true;
            }
        }
        if(leftFlag){
            root.left = null;
        }
        if(rightFlag){
            root.right = null;
        }
        return false;
    }

}
