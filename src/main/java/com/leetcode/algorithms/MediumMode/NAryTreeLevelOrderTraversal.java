package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author JoeyYoung
 * @ClassName: N-ary Tree Level Order Traversal
 * @Date 2021/12/1 10:20
 * @Description:
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 *
 * Example 2:
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 *
 *
 * Constraints:
 *
 *     The height of the n-ary tree is less than or equal to 1000
 *     The total number of nodes is between [0, 104]
 */
public class NAryTreeLevelOrderTraversal {
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
    }

    /**
     * Runtime: 46 ms, faster than 5.43% of Java online submissions for N-ary Tree Level Order Traversal.
     * Memory Usage: 40.6 MB, less than 34.63% of Java online submissions for N-ary Tree Level Order Traversal.
     */
    /*public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        boolean flag = true;
        boolean change = false;
        Queue<Node> queue1 = new LinkedTransferQueue<>();
        Queue<Node> queue2 = new LinkedTransferQueue<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();

        queue1.add(root);
        while(queue1.size() != 0 || queue2.size() != 0){
            Node tmp;
            if(flag){
                tmp = queue1.poll();
                tmpList.add(tmp.val);
                if(tmp.children.size() != 0){
                    queue2.addAll(tmp.children);
                }
            } else {
                tmp = queue2.poll();
                tmpList.add(tmp.val);
                if(tmp.children.size() != 0){
                    queue1.addAll(tmp.children);
                }
            }
            if(queue1.size() == 0 && flag == true){
                flag = false;
                change = true;
            } else if(queue2.size() == 0 && flag == false){
                flag = true;
                change = true;
            }
            if(change){
                result.add(tmpList);
                tmpList = new ArrayList<>();
                change = false;
            }
        }
        return result;
    }*/

    /**
     * Runtime: 2 ms, faster than 92.76% of Java online submissions for N-ary Tree Level Order Traversal.
     * Memory Usage: 39.7 MB, less than 87.46% of Java online submissions for N-ary Tree Level Order Traversal.
     */
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int nextLevel = 0;
        int currentLevelRemain = 1;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        while(queue.size() != 0){
            Node tmp;
            tmp = queue.poll();
            currentLevelRemain--;
            tmpList.add(tmp.val);
            if(tmp.children.size() != 0){
                nextLevel += tmp.children.size();
                queue.addAll(tmp.children);
            }
            if(currentLevelRemain == 0){
                currentLevelRemain = nextLevel;
                nextLevel = 0;
                result.add(tmpList);
                tmpList = new ArrayList<>();
            }
        }
        return result;
    }

}
