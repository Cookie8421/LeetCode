package com.leetcode.algorithms.MediumMode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author JoeyYoung
 * @ClassName: Maximum Level Sum of a Binary Tree
 * @Date 2021/12/9 9:36
 * @Description:
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 *
 * Example 2:
 *
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 104].
 *     -105 <= Node.val <= 105
 */
public class MaximumLevelSumOfABinaryTree {

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

    private Queue<TreeNode> nextLevel;

    public int maxLevelSum(TreeNode root) {
        nextLevel = new LinkedList<TreeNode>();
        nextLevel.add(root);
        return currentMaxLevelSum(1, root.val, 1);
    }

    private int currentMaxLevelSum(int level, int maxSum, int maxSumLevel){
        if (nextLevel.isEmpty())
            return maxSumLevel;

        int sum = 0;
        int amountChildren = nextLevel.size();
        TreeNode child;
        for(int i = 0; i < amountChildren; i++){
            child = nextLevel.poll();
            sum += child.val;
            if (child.right != null)
                nextLevel.add(child.right);
            if (child.left != null)
                nextLevel.add(child.left);
        }

        if (sum > maxSum)
            return currentMaxLevelSum(level+1, sum, level);
        else
            return currentMaxLevelSum(level+1, maxSum, maxSumLevel);
    }


    public static void main(String[] args) {

    }

}
