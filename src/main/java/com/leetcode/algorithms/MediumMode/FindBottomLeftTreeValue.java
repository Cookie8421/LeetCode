package com.leetcode.algorithms.MediumMode;

/**
 * @Author JoeyYoung
 * @ClassName: Find Bottom Left Tree Value
 * @Date 2021/11/27 13:19
 * @Description:
 * Given the root of a binary tree,
 * return the leftmost value in the last row of the tree.
 *
 * Example 1:
 *
 * Input: root = [2,1,3]
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 104].
 *     -231 <= Node.val <= 231 - 1
 *
 */
public class FindBottomLeftTreeValue {

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
     * Runtime: 1 ms, faster than 73.77% of Java online submissions for Find Bottom Left Tree Value.
     * Memory Usage: 41.3 MB, less than 12.38% of Java online submissions for Find Bottom Left Tree Value.
     */
    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] array = new int[]{0, root.val};
        findLeaves(root.left, 1, array);
        findLeaves(root.right, 1, array);
        return array[1];
    }
    public void findLeaves(TreeNode root, int currentLevel, int[] array){
        if(root == null){
            return;
        }
        if(currentLevel > array[0]){
            array[0] = currentLevel;
            array[1] = root.val;
        }
        if(root.left == null && root.right == null){
            return;
        }
        if(root.left != null){
            findLeaves(root.left, currentLevel + 1, array);
        }
        if(root.right != null){
            findLeaves(root.right,currentLevel + 1, array);
        }
    }

}
