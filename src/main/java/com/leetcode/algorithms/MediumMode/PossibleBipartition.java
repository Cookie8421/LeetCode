package com.leetcode.algorithms.MediumMode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
 *
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4] and group2 [2,3].
 * Example 2:
 *
 * Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 *
 * Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * All the pairs of dislikes are unique.
 */
public class PossibleBipartition {

    /**
     * Runtime
     * 11 ms
     * Memory
     * 50.5 MB
     */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // 1. Create the graph
        List<Integer> dislikeArray[] = new List[N + 1];
        for(int i = 0; i < dislikeArray.length; i++) {
            dislikeArray[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < dislikes.length; i++) {
            dislikeArray[dislikes[i][0]].add(dislikes[i][1]);
            dislikeArray[dislikes[i][1]].add(dislikes[i][0]);
        }

        // 2. Color the graph
        int group[] = new int[N + 1];
        Arrays.fill(group, -1);
        for(int i = 1; i <= N; i++) {
            if( group[i] == -1 && !paint(group, i, dislikeArray, 0) )
                return false;
        }
        return true;
    }

    public boolean paint(int group[], int index, List<Integer> dislikeArray[], int color) {
        group[index] = color;
        for(int i = 0; i < dislikeArray[index].size(); i++) {
            int nextIndex = dislikeArray[index].get(i);
            if( group[nextIndex] == color )
                return false;
            if( group[nextIndex] == -1 && !paint(group, nextIndex, dislikeArray, 1 - color))
                return false;
        }
        return true;
    }


    /**
     * UnionFind
     *
     * Runtime
     * 40 ms
     * Memory
     * 49.9 MB
     *
     *
     * public boolean possibleBipartition(int n, int[][] dislikes) {
     *     Map<Integer, Set<Integer>> graph = buildGraph(dislikes, n);
     *     UnionFind uf = new UnionFind(n);
     *
     *     for(int i = 1; i < n+1; i++) {
     *       Set<Integer> neighbors = graph.get(i);
     *       if(neighbors.size() == 0) continue;
     *       int firstNeighbor = neighbors.iterator().next(); // gets the first item in the set
     *
     *       for(int neighbor : neighbors) {
     *         if(uf.isConnected(i, neighbor)) return false; // if vertex i is connected with any of its neighbors, graph is not bipartite
     *         uf.union(firstNeighbor, neighbor); // unionize all its neighbors
     *       }
     *     }
     *
     *     return true;
     *   }
     *
     *   public Map<Integer, Set<Integer>> buildGraph(int[][] edges, int n) {
     *     Map<Integer, Set<Integer>> graph = new HashMap<>();
     *
     *     for(int i = 1; i < n+1; i++) graph.put(i, new HashSet<>());
     *
     *     for(int[] edge : edges) {
     *       int src = edge[0];
     *       int dest = edge[1];
     *
     *       graph.get(src).add(dest);
     *       graph.get(dest).add(src);
     *     }
     *
     *     return graph;
     *   }
     *
     *   class UnionFind {
     *     int[] parent;
     *     int[] rank;
     *
     *     public UnionFind(int n) {
     *       parent = new int[n+1];
     *       rank = new int[n+1];
     *
     *       for(int i = 0; i < n+1; i++) {
     *         parent[i] = i;
     *       }
     *     }
     *
     *     public void union(int x, int y) {
     *       int rootX = find(x);
     *       int rootY = find(y);
     *
     *       if(rootX != rootY) {
     *         if(rank[rootX] > rank[rootY]) {
     *           rank[rootX]++;
     *           parent[rootY] = rootX;
     *         } else {
     *           rank[rootY]++;
     *           parent[rootX] = rootY;
     *         }
     *       }
     *     }
     *
     *     public int find(int x) {
     *       if(parent[x] == x) return x;
     *
     *       int root = find(parent[x]);
     *       parent[x] = root; //path compression
     *       return root;
     *     }
     *
     *     public boolean isConnected(int x, int y) {
     *       return find(x) == find(y);
     *     }
     *   }
     */

}
