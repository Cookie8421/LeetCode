package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * There is an undirected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
 *
 * You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree. You are also given an integer array restricted which represents restricted nodes.
 *
 * Return the maximum number of nodes you can reach from node 0 without visiting a restricted node.
 *
 * Note that node 0 will not be a restricted node.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
 * Output: 4
 * Explanation: The diagram above shows the tree.
 * We have that [0,1,2,3] are the only nodes that can be reached from node 0 without visiting a restricted node.
 *
 * Example 2:
 *
 * Input: n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
 * Output: 3
 * Explanation: The diagram above shows the tree.
 * We have that [0,5,6] are the only nodes that can be reached from node 0 without visiting a restricted node.
 *
 *
 *
 * Constraints:
 *
 *     2 <= n <= 105
 *     edges.length == n - 1
 *     edges[i].length == 2
 *     0 <= ai, bi < n
 *     ai != bi
 *     edges represents a valid tree.
 *     1 <= restricted.length < n
 *     1 <= restricted[i] < n
 *     All the values of restricted are unique.
 */
public class ReachableNodesWithRestrictions {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        /**
         * Runtime: 36 ms, faster than 99.45% of Java online submissions for Reachable Nodes With Restrictions.
         * Memory Usage: 93.7 MB, less than 97.76% of Java online submissions for Reachable Nodes With Restrictions.
         */
        UnionFind uf = new UnionFind(n);
        Set<Integer> set = new HashSet<>();
        for(int num: restricted){
            set.add(num);
        }
        for(int [] edge: edges){
            int x = edge[0];
            int y = edge[1];
            if(set.contains(x) || set.contains(y)) continue;
            uf.union(x,y);
        }
        return uf.getSize();
    }

    private class UnionFind{
        int[] root;
        public UnionFind(int n){
            root = new int[n];
            for(int i =0 ; i< n; i ++) root[i] = i;
        }
        public int find(int x){
            if(root[x] != x) root[x] = find(root[x]);
            return root[x];
        }
        public void union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx == rooty) return;
            root[rootx] = rooty;
        }
        public int getSize(){
            int root0 = find(0);
            int size = 0;
            for(int i = 0; i < root.length; i ++){
                if(find(i)== root0) size++;
            }
            return size;
        }
    }

}
