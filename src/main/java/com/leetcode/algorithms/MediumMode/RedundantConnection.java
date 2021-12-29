package com.leetcode.algorithms.MediumMode;


/**
 * @Author JoeyYoung
 * @ClassName: Redundant Connection
 * @Date 2021/12/24 8:48
 * @Description:
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * You are given a graph that started as a tree with n nodes labeled from 1 to n,
 * with one additional edge added. The added edge has two different vertices chosen from 1 to n,
 * and was not an edge that already existed.
 * The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates
 * that there is an edge between nodes ai and bi in the graph.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes.
 * If there are multiple answers, return the answer that occurs last in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 *
 * Example 2:
 *
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 *
 *
 *
 * Constraints:
 *
 *     n == edges.length
 *     3 <= n <= 1000
 *     edges[i].length == 2
 *     1 <= ai < bi <= edges.length
 *     ai != bi
 *     There are no repeated edges.
 *     The given graph is connected.
 */
public class RedundantConnection {


    int MAX_EDGE_VAL = 1000;

    /**
     * Union-Find
     * Runtime: 1 ms, faster than 64.12% of Java online submissions for Redundant Connection.
     * Memory Usage: 39.5 MB, less than 44.12% of Java online submissions for Redundant Connection.
     */
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(MAX_EDGE_VAL + 1);
        for (int[] edge: edges) {
            if (!dsu.union(edge[0], edge[1])) return edge;
        }
        throw new AssertionError();
    }


    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i;
            rank = new int[size];
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int xr = find(x), yr = find(y);
            if (xr == yr) {
                return false;
            } else if (rank[xr] < rank[yr]) {
                parent[xr] = yr;
            } else if (rank[xr] > rank[yr]) {
                parent[yr] = xr;
            } else {
                parent[yr] = xr;
                rank[xr]++;
            }
            return true;
        }
    }

}
