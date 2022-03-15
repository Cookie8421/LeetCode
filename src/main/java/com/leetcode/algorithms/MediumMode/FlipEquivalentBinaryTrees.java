package com.leetcode.algorithms.MediumMode;

/**
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
 *
 * A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
 *
 * Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.
 */
public class FlipEquivalentBinaryTrees {

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
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flip Equivalent Binary Trees.
     * Memory Usage: 42.6 MB, less than 8.60% of Java online submissions for Flip Equivalent Binary Trees.
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if((root1 == null && root2 != null) || (root1 != null && root2 == null)){
            return false;
        } else if(root1 == null && root2 == null){
            return true;
        } else if(root1.val != root2.val){
            return false;
        }
         if((flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
         || (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))){
             return true;
         }
         return false;
    }
    
}
