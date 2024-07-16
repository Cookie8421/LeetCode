package com.leetcode.algorithms.MediumMode;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

If isLefti == 1, then childi is the left child of parenti.
If isLefti == 0, then childi is the right child of parenti.
Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

 

Example 1:


Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
Output: [50,20,80,15,17,19]
Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.
Example 2:


Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
Output: [1,2,null,null,3,4]
Explanation: The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram.
 

Constraints:

1 <= descriptions.length <= 104
descriptions[i].length == 3
1 <= parenti, childi <= 105
0 <= isLefti <= 1
The binary tree described by descriptions is valid.
 */
public class CreateBinaryTreeFromDescriptions {

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
     * Runtime
        66
        ms
        Beats
        64.97%
        Analyze Complexity
        Memory
        54.90
        MB
        Beats
        97.77%
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode root = null;
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        for(int i = 0; i < descriptions.length; i++){
            TreeNode parent = null;
            TreeNode child = null;
            int parentValue = descriptions[i][0];
            int childValue = descriptions[i][1];
            if(!map.containsKey(parentValue)){
                parent = new TreeNode(parentValue);
                map.put(parentValue, parent);
            } else {
                parent = map.get(parentValue);
            }
            if(!map.containsKey(childValue)){
                child = new TreeNode(childValue);
                map.put(childValue, child);
            } else {
                child = map.get(childValue);
            }
            if(descriptions[i][2] == 1){
                parent.left = child;
            } else {
                parent.right = child;
            }
            parentMap.put(child, parent);
            if(root == null){
                root = parent;
            }
        }
        while(parentMap.containsKey(root)){
            root = parentMap.get(root);
        }
        return root;
    }

    public static void main(String[] args) {
        CreateBinaryTreeFromDescriptions test = new CreateBinaryTreeFromDescriptions();
        int[][] descriptions = new int[][]{{20,50,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        TreeNode root = test.createBinaryTree(descriptions);
        System.out.println(root);
    }

}
