package com.leetcode.algorithms.MediumMode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author JoeyYoung
 * @ClassName: Even Odd Tree
 * @Date 2021/12/13 18:13
 * @Description:
 * A binary tree is named Even-Odd if it meets the following conditions:
 *
 *     The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
 *     For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
 *     For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
 *
 * Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * Output: true
 * Explanation: The node values on each level are:
 * Level 0: [1]
 * Level 1: [10,4]
 * Level 2: [3,7,9]
 * Level 3: [12,8,6,2]
 * Since levels 0 and 2 are all odd and increasing, and levels 1 and 3 are all even and decreasing,
 * the tree is Even-Odd.
 *
 * Example 2:
 *
 * Input: root = [5,4,2,3,3,7]
 * Output: false
 * Explanation: The node values on each level are:
 * Level 0: [5]
 * Level 1: [4,2]
 * Level 2: [3,3,7]
 * Node values in the level 2 must be in strictly increasing order, so the tree is not Even-Odd.
 *
 * Example 3:
 *
 * Input: root = [5,9,1,3,5,7]
 * Output: false
 * Explanation: Node values in the level 1 should be even integers.
 *
 * Example 4:
 *
 * Input: root = [1]
 * Output: true
 *
 * Example 5:
 *
 * Input: root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
 * Output: true
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 105].
 *     1 <= Node.val <= 106
 */
public class EvenOddTree {

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
     * Runtime: 11 ms, faster than 50.91% of Java online submissions for Even Odd Tree.
     * Memory Usage: 56.1 MB, less than 60.56% of Java online submissions for Even Odd Tree.
     */
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        int tmp = Integer.MAX_VALUE;
        boolean isEven = false;
        while(!queue.isEmpty()){
            for(; count > 0; count--){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                if(tmp == Integer.MAX_VALUE) {
                    tmp = queue.poll().val;
                    if((!isEven && tmp % 2 == 0) || (isEven && tmp % 2 != 0)){
                        return false;
                    }
                } else {
                    int current = queue.poll().val;
                    if((!isEven && current <= tmp) || (isEven && current >= tmp)){
                        return false;
                    } else if((!isEven && current % 2 == 0) || (isEven && current % 2 != 0)){
                        return false;
                    } else {
                        tmp = current;
                    }
                }
            }
            count = queue.size();
            tmp = Integer.MAX_VALUE;
            isEven = !isEven;
        }
        return true;
    }

}
