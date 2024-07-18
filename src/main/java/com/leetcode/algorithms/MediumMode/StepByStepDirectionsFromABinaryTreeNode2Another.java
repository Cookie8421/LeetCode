package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.

Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.

 

Example 1:


Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
Output: "UURL"
Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
Example 2:


Input: root = [2,1], startValue = 2, destValue = 1
Output: "L"
Explanation: The shortest path is: 2 → 1.
 

Constraints:

The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= n
All the values in the tree are unique.
1 <= startValue, destValue <= n
startValue != destValue
 */
public class StepByStepDirectionsFromABinaryTreeNode2Another {
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
     * too much  recursion
     * memory limit exceed
     */

    // TreeNode start = null;

    // Map<TreeNode, TreeNode> parentNodeMap = new HashMap<>();

    // Set<Integer> traversaedSet = new HashSet<>();

    // boolean flag = false;
    
    // public String getDirections(TreeNode root, int startValue, int destValue) {
    //     String res = "";
    //     start = root;
    //     helper(root, startValue, null);
    //     return helperII(start, "", res, destValue);
    // }

    // public void helper(TreeNode current, int startValue, TreeNode parent){
    //     if(current == null){
    //         return;
    //     }
    //     traversaedSet.add(current.val);
    //     if(current.val == startValue){
    //         start = current;
    //     }
    //     if(parent != null){
    //         parentNodeMap.put(current, parent);
    //     }
    //     helper(current.left, startValue, current);
    //     helper(current.right, startValue, current);
    // }

    // public String helperII(TreeNode current, String direction, String res, int destValue){
    //     String currentRes = res;
    //     if(current == null || !traversaedSet.contains(current.val)){
    //         return res;
    //     }
    //     traversaedSet.remove(current.val);
    //     if(current.val == destValue){
    //         flag = true;
    //         return res;
    //     }
    //     currentRes = helperII(current.left, "L", res + "L", destValue);
    //     if(flag){
    //         return currentRes;
    //     }
    //     currentRes = helperII(current.right, "R", res + "R", destValue);
    //     if(flag){
    //         return currentRes;
    //     }
    //     currentRes = helperII(parentNodeMap.get(current), "U", res + "U", destValue);
    //     if(flag){
    //         return currentRes;
    //     }
    //     return res;
    // }


    /**
     * Runtime
        27
        ms
        Beats
        48.76%
        Analyze Complexity
        Memory
        75.72
        MB
        Beats
        94.25%
     */
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<String> pathToStart = new ArrayList<>();
        List<String> pathToDestination = new ArrayList<>();
        findPathFromRoot(root, startValue, pathToStart);
        findPathFromRoot(root, destValue, pathToDestination);

        int commonPathLen = 0;
        while (commonPathLen < pathToStart.size() && commonPathLen < pathToDestination.size() &&
               pathToStart.get(commonPathLen).equals(pathToDestination.get(commonPathLen))) {
            commonPathLen++;
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < pathToStart.size() - commonPathLen; i++) {
            res.add("U");
        }
        res.addAll(pathToDestination.subList(commonPathLen, pathToDestination.size()));

        return String.join("", res);
    }

    private boolean findPathFromRoot(TreeNode curNode, int targetValue, List<String> pathToAppend) {
        if (curNode == null) {
            return false;
        }
        if (curNode.val == targetValue) {
            return true;
        }

        pathToAppend.add("R");
        if (findPathFromRoot(curNode.right, targetValue, pathToAppend)) {
            return true;
        }
        pathToAppend.remove(pathToAppend.size() - 1);

        pathToAppend.add("L");
        if (findPathFromRoot(curNode.left, targetValue, pathToAppend)) {
            return true;
        }
        pathToAppend.remove(pathToAppend.size() - 1);

        return false;
    }
}
