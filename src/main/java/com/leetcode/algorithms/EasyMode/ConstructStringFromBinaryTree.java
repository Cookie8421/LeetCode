package com.leetcode.algorithms.EasyMode;

/**
 * @Author JoeyYoung
 * @ClassName: Construct String from Binary Tree
 * @Date 2021/12/10 16:39
 * @Description:
 * Given the root of a binary tree,
 * construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way,
 * and return it.
 *
 * Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4]
 * Output: "1(2(4))(3)"
 * Explanation: Originally, it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)"
 *
 * Example 2:
 *
 * Input: root = [1,2,3,null,4]
 * Output: "1(2()(4))(3)"
 * Explanation: Almost the same as the first example,
 * except we cannot omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [1, 104].
 *     -1000 <= Node.val <= 1000
 */
public class ConstructStringFromBinaryTree {

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
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Construct String from Binary Tree.
     * Memory Usage: 39.1 MB, less than 85.04% of Java online submissions for Construct String from Binary Tree.
     */
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();
        dps(root, result);
        return result.toString();
    }

    private static void dps(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("()");
            return;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null){
            return;
        }
        if(root.left == null){
            sb.append("()");
        }   else {
            sb.append("(");
            dps(root.left,sb);
            sb.append(")");
        }
        if(root.right != null){
            sb.append("(");
            dps(root.right, sb);
            sb.append(")");
        }
    }

}
