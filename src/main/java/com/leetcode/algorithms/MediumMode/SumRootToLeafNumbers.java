package com.leetcode.algorithms.MediumMode;

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 *
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 9
 * The depth of the tree will not exceed 10.
 */
public class SumRootToLeafNumbers {

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

    Integer sum = 0;

    public int sumNumbers(TreeNode root) {
        /**
         * Runtime: 15 ms, faster than 5.53% of Java online submissions for Sum Root to Leaf Numbers.
         * Memory Usage: 43.2 MB, less than 5.76% of Java online submissions for Sum Root to Leaf Numbers.
         */
        dfs(root, "");
        return sum;
    }

    private void dfs(TreeNode current, String cur){
        if(current == null){
            return;
        }
        if(current.left == null && current.right == null){
            sum += Integer.parseInt(cur+current.val);
        } else {
            dfs(current.left, cur + current.val);
            dfs(current.right, cur + current.val);
        }
    }


    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
     * Memory Usage: 41.8 MB, less than 44.03% of Java online submissions for Sum Root to Leaf Numbers.
     */
    /*int final_sum =0;
    public int sumNumbers(TreeNode root)
    {
        if(root == null)
            return 0;

        count_sum(root , 0);
        return final_sum;
    }

    private void count_sum(TreeNode root , int sum)
    {
        if(root == null)
            return;

        sum = sum *10 + root.val;

        if(root.left == null && root.right == null)
            final_sum += sum;

        count_sum(root.left , sum);
        count_sum(root.right , sum);
    }*/

}
