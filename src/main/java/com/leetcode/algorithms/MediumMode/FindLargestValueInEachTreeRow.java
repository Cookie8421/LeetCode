package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * Example 2:
 *
 * Input: root = [1,2,3]
 * Output: [1,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree will be in the range [0, 104].
 * -231 <= Node.val <= 231 - 1
 */
public class FindLargestValueInEachTreeRow {

    class TreeNode {
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
     * Runtime
     * 2 ms
     * Memory
     * 43.2 MB
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //BSF
        int count = 1;
        int rowMax = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null){
           return ans;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            if(count == 0){
                ans.add(rowMax > 0 ? rowMax : 0);
                count = queue.size();
                rowMax = Integer.MIN_VALUE;
            }
            TreeNode treeNode = queue.poll();
            rowMax = Math.max(rowMax, treeNode.val);
            if(treeNode.left != null){
                queue.add(treeNode.left);
            }
            if(treeNode.right != null){
                queue.add(treeNode.right);
            }
            count--;
        }
        ans.add(rowMax);
        return ans;
    }

}
