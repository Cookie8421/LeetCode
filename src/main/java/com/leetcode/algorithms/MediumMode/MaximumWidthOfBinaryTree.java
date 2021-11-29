package com.leetcode.algorithms.MediumMode;

import java.util.HashMap;

/**
 * @Author JoeyYoung
 * @ClassName: Maximum Width of Binary Tree
 * @Date 2021/11/27 16:21
 * @Description:
 * Given the root of a binary tree, return the maximum width of the given tree.
 *
 * The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes
 * (the leftmost and rightmost non-null nodes),
 * where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * It is guaranteed that the answer will in the range of 32-bit signed integer.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 *
 * Example 2:
 *
 * Input: root = [1,3,null,5,3]
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 *
 * Example 3:
 *
 * Input: root = [1,3,2,5]
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 *
 * Example 4:
 *
 * Input: root = [1,3,2,5,null,null,9,6,null,null,7]
 * Output: 8
 * Explanation: The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 3000].
 *     -100 <= Node.val <= 100
 *
 */
public class MaximumWidthOfBinaryTree {

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
     * Runtime: 1 ms, faster than 98.88% of Java online submissions for Maximum Width of Binary Tree.
     * Memory Usage: 39.2 MB, less than 49.97% of Java online submissions for Maximum Width of Binary Tree.
     */
    HashMap<Integer,Integer> hm=new HashMap<>();
    int maxWidth=0;
    public int widthOfBinaryTree(TreeNode root) {
        width(root,0,0);
        return maxWidth;
    }
    public void width(TreeNode root,int depth,int position){
        if(root==null){
            return;
        }
        if(!hm.containsKey(depth)){
            hm.put(depth,position);
        }
        maxWidth=Math.max(maxWidth,position-hm.get(depth)+1);
        width(root.left,depth+1,position*2);
        width(root.right,depth+1,position*2+1);
    }

}
