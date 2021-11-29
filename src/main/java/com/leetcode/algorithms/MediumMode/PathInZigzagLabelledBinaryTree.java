package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author JoeyYoung
 * @ClassName: Path In Zigzag Labelled Binary Tree
 * @Date 2021/11/29 17:00
 * @Description:
 * In an infinite binary tree where every node has two children,
 * the nodes are labelled in row order.
 *
 * In the odd numbered rows (ie., the first, third, fifth,...),
 * the labelling is left to right,
 * while in the even numbered rows (second, fourth, sixth,...),
 * the labelling is right to left.
 *
 * Given the label of a node in this tree,
 * return the labels in the path from the root of the tree to the node with that label.
 *
 *
 *
 * Example 1:
 *
 * Input: label = 14
 * Output: [1,3,4,14]
 *
 * Example 2:
 *
 * Input: label = 26
 * Output: [1,2,6,10,26]
 *
 *
 *
 * Constraints:
 *
 *     1 <= label <= 10^6
 *
 */
public class PathInZigzagLabelledBinaryTree {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path In Zigzag Labelled Binary Tree.
     * Memory Usage: 36.9 MB, less than 46.99% of Java online submissions for Path In Zigzag Labelled Binary Tree.
     */
    public List<Integer> pathInZigZagTree(int n) {
        int llv=1;
        int ctlv=0;
        while(ctlv<n){
            ctlv+=llv;
            llv*=2;
        }
        llv/=2;

        ArrayList<Integer> ans = new ArrayList<Integer>();

        while(n!=1){
            ans.add(n);
            int comp=(3*llv-n-1);
            int par=(comp/2);
            n=par;
            llv/=2;
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }

}
