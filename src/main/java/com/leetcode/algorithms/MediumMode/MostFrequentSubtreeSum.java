package com.leetcode.algorithms.MediumMode;

import java.util.*;

/**
 * Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.
 *
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,2,-3]
 * Output: [2,-3,4]
 * Example 2:
 *
 *
 * Input: root = [5,2,-5]
 * Output: [2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 */
public class MostFrequentSubtreeSum {

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

    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        /**
         * Runtime
         * 10 ms
         * Memory
         * 45.8 MB
         */
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> list = new ArrayList<>();
        for(Integer i : map.keySet()){
            if(map.get(i) == max){
                list.add(i);
            }
        }
        int[] ans = new int[list.size()];
        int index = 0;
        for(Integer i : list){
            ans[index++] = i;
        }
        return ans;
    }

    public int dfs(TreeNode current, Map<Integer, Integer> ans){
        if(current == null){
            return 0;
        }
        int t = dfs(current.left, ans) + dfs(current.right, ans) + current.val;
        if(ans.containsKey(t)){
            int v = ans.get(t);
            ans.put(t, ++v);
            max = Math.max(max, v);
        } else {
            ans.put(t,1);
            max = Math.max(max, 1);
        }
        return t;
    }


}
