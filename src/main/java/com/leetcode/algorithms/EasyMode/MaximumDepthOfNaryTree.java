package com.leetcode.algorithms.EasyMode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 *
 * Example 2:
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 5
 *
 *
 *
 * Constraints:
 *
 *     The total number of nodes is in the range [0, 104].
 *     The depth of the n-ary tree is less than or equal to 1000.
 */
public class MaximumDepthOfNaryTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node root) {
        /**
         * Runtime: 2 ms, faster than 31.08% of Java online submissions for Maximum Depth of N-ary Tree.
         * Memory Usage: 44.3 MB, less than 41.70% of Java online submissions for Maximum Depth of N-ary Tree.
         */
        int ans = 0;
        int count = 1;
        int nextCount = 0;
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            return ans;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            count--;
            for(int i = 0; i < temp.children.size(); i++){
                queue.offer(temp.children.get(i));
                nextCount++;
            }
            if(count == 0){
                count = nextCount;
                nextCount = 0;
                ans++;
            }
        }
        return ans;


        /**
         * Runtime: 1 ms, faster than 82.96% of Java online submissions for Maximum Depth of N-ary Tree.
         * Memory Usage: 43.9 MB, less than 62.25% of Java online submissions for Maximum Depth of N-ary Tree.
         */
        /*
        public int maxDepth(Node root) {
            if (root == null) return 0;
            int[] max = new int[]{0};
            dfs(root,1,max);
            return max[0];
        }
        public static void dfs(Node root, int depth, int[] max) {
            if (depth>max[0]) max[0] = depth;
            if(root==null){
                return;
            }
            ++depth;
            for(Node n:root.children) dfs(n, depth, max);
        }
         */
    }

}
