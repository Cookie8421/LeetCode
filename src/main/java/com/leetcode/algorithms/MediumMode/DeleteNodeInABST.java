package com.leetcode.algorithms.MediumMode;

import sun.reflect.generics.tree.Tree;

/**
 * @Author JoeyYoung
 * @ClassName: Delete Node in a BST
 * @Date 2021/11/22 13:48
 * @Description:
 * Given a root node reference of a BST and a key,
 * delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 *     Search for a node to remove.
 *     If the node is found, delete the node.
 *
 * Example 1:
 *
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 104].
 *     -105 <= Node.val <= 105
 *     Each node has a unique value.
 *     root is a valid binary search tree.
 *     -105 <= key <= 105
 */
public class DeleteNodeInABST {
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
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
     * Memory Usage: 46.8 MB, less than 18.19% of Java online submissions for Delete Node in a BST.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(key<root.val){
            root.left = deleteNode(root.left,key);
            return root;
        }

        else if(key>root.val){
            root.right = deleteNode(root.right,key);
            return root;
        }

        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                TreeNode min = root.right;
                while(min.left!=null){
                    min = min.left;
                }

                root.val = min.val;
                root.right = deleteNode(root.right,min.val);
                return root;
            }
        }
    }

}
