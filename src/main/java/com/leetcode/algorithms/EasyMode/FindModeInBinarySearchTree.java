package com.leetcode.algorithms.EasyMode;

import java.util.*;

/**
 * @Author JoeyYoung
 * @ClassName: Find Mode in Binary Search Tree
 * @Date 2021/11/30 8:47
 * @Description:
 * Given the root of a binary search tree (BST) with duplicates,
 * return all the mode(s) (i.e., the most frequently occurred element) in it.
 *
 * If the tree has more than one mode, return them in any order.
 *
 * Assume a BST is defined as follows:
 *
 *     The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 *     The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,2,2]
 * Output: [2]
 *
 * Example 2:
 *
 * Input: root = [0]
 * Output: [0]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 104].
 *     -105 <= Node.val <= 105
 *
 *
 * Follow up: Could you do that without using any extra space?
 * (Assume that the implicit stack space incurred due to recursion does not count).
 *
 */
public class FindModeInBinarySearchTree {

    int count = 0;
    //tmpArray[0]:currentVal;
    //tmpArray[1]:currentCount;
    int[] tmpArray = new int[2];
    List<Integer> list = new ArrayList<>();

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


    Integer prev=null;
    int max_count=0;
    int curr_count=1;
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        helper(root,ans);
        int[] arr=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            arr[i]=ans.get(i);
        }
        return arr;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Mode in Binary Search Tree.
     * Memory Usage: 39.3 MB, less than 93.08% of Java online submissions for Find Mode in Binary Search Tree.
     */
    private void helper(TreeNode root,ArrayList<Integer> ans){
        if(root==null){
            return;
        }
        helper(root.left,ans);
        if(prev!=null){
            if(prev==root.val){
                curr_count++;
            }else{
                curr_count=1;
            }
        }
        if(curr_count>max_count){
            max_count=curr_count;
            ans.clear();
            ans.add(root.val);
        }else if(curr_count==max_count){
            ans.add(root.val);
        }
        prev=root.val;
        helper(root.right,ans);
    }
}
