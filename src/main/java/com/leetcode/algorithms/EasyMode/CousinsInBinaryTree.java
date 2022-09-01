package com.leetcode.algorithms.EasyMode;

/**
 * Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
 *
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 *
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 *
 * Example 2:
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 *
 * Example 3:
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [2, 100].
 *     1 <= Node.val <= 100
 *     Each node has a unique value.
 *     x != y
 *     x and y are exist in the tree.
 */
public class CousinsInBinaryTree {

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

    int[][] array = new int[2][2];

    public boolean isCousins(TreeNode root, int x, int y) {
        /**
         * Runtime: 1 ms, faster than 64.66% of Java online submissions for Cousins in Binary Tree.
         * Memory Usage: 42.2 MB, less than 34.43% of Java online submissions for Cousins in Binary Tree.
         */
        getParentValue(root, x, y, array, 0);
        if(array[0][1] == array[1][1] && array[0][0] != array[1][0]){
            return true;
        }
        return false;
    }

    public void getParentValue(TreeNode root, int x, int y, int[][] array, int level){
        if(root == null){
            return;
        }
        level++;
        getParentValue(root.left, x, y, array, level);
        if(root.left != null){
            if(root.left.val == x){
                array[0][0] = root.val;
                array[0][1] = level;
            } else if(root.left.val == y){
                array[1][0] = root.val;
                array[1][1] = level;
            }
        }
        if(root.right != null){
            if(root.right.val == x){
                array[0][0] = root.val;
                array[0][1] = level;
            } else if(root.right.val == y){
                array[1][0] = root.val;
                array[1][1] = level;
            }
        }
        getParentValue(root.right, x, y, array, level);
    }

}
