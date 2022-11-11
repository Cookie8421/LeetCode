package com.leetcode.algorithms.MediumMode;

/**
 * Two players play a turn based game on a binary tree. We are given the root of this binary tree, and the number of nodes n in the tree. n is odd, and each node has a distinct value from 1 to n.
 *
 * Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x. The first player colors the node with value x red, and the second player colors the node with value y blue.
 *
 * Then, the players take turns starting with the first player. In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node (either the left child, right child, or parent of the chosen node.)
 *
 * If (and only if) a player cannot choose such a node in this way, they must pass their turn. If both players pass their turn, the game ends, and the winner is the player that colored more nodes.
 *
 * You are the second player. If it is possible to choose such a y to ensure you win the game, return true. If it is not possible, return false.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
 * Output: true
 * Explanation: The second player can choose the node with value 2.
 * Example 2:
 *
 * Input: root = [1,2,3], n = 3, x = 1
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= x <= n <= 100
 * n is odd.
 * 1 <= Node.val <= n
 * All the values of the tree are unique.
 */
public class BinaryTreeColoringGame {

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
    int count;

    /**
     * Runtime
     * 1 ms
     * Memory
     * 41.7 MB
     */
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (root == null)
            return false;

        // find the node with value x
        TreeNode target = search(root, x);

        // separate the tree into three parts around the target: left subtrees, right subtrees, and others
        int left = subtreeCount(target.left);
        int right = subtreeCount(target.right);
        int remain = n - left - right - 1;

        // return true if the count of any two part is greater than the count of the third part
        return (remain > left + right + 1) || (left > remain + right + 1) || (right > left + remain + 1);
    }

    private TreeNode search(TreeNode root, int x) {
        if (root == null)
            return null;

        if (root.val == x)
            return root;

        TreeNode left = search(root.left, x);
        TreeNode right = search(root.right, x);
        if (left == null && right == null)
            return null;
        else if (left != null)
            return left;
        return right;
    }

    private int subtreeCount(TreeNode root) {
        if (root == null)
            return 0;

        int leftNodes = subtreeCount(root.left);
        int rightNodes = subtreeCount(root.right);
        return leftNodes + rightNodes + 1;
    }


}
