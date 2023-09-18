package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation:
 *
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 * Example 2:
 *
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 *
 *
 * Constraints:
 *
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * All pairs (xi, yi) are distinct.
 */
public class MinCostToConnectAllPoints {

    public static int manhattan_distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    /**
     * Runtime
     * 79 ms
     * Beats
     * 60.75%
     * Memory
     * 45.1 MB
     * Beats
     * 66.50%
     *
     * Prim's Algorithm is another method for finding the Minimum Spanning Tree.
     * It starts from an arbitrary node and greedily chooses the edge with the smallest weight that connects a visited and an unvisited node.
     *
     * The Mechanics of Prim's Algorithm in "Min Cost to Connect All Points"
     * Initialize Priority Queue:
     *
     * Start from an arbitrary point and initialize a minimum priority queue with its edges.
     * Visited Nodes Tracking:
     *
     * Keep track of visited nodes to ensure that each node is visited exactly once.
     * Iterate and Add to MST:
     *
     * Pop the edge with the smallest weight from the priority queue. If the edge leads to an unvisited node, add the edge's weight to the total MST weight, and insert all edges from that node into the priority queue.
     * Completion Check:
     *
     * Continue this process until all nodes have been visited.
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        HashMap<Integer, Integer> heap_dict = new HashMap<>();
        heap_dict.put(0, 0);

        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        min_heap.add(new int[]{0, 0});

        int mst_weight = 0;

        while (!min_heap.isEmpty()) {
            int[] top = min_heap.poll();
            int w = top[0], u = top[1];

            if (visited[u] || heap_dict.getOrDefault(u, Integer.MAX_VALUE) < w) continue;

            visited[u] = true;
            mst_weight += w;

            for (int v = 0; v < n; ++v) {
                if (!visited[v]) {
                    int new_distance = manhattan_distance(points[u], points[v]);
                    if (new_distance < heap_dict.getOrDefault(v, Integer.MAX_VALUE)) {
                        heap_dict.put(v, new_distance);
                        min_heap.add(new int[]{new_distance, v});
                    }
                }
            }
        }

        return mst_weight;
    }


    /**
     * Runtime
     * 352 ms
     * Beats
     * 28.33%
     * Memory
     * 57.7 MB
     * Beats
     * 52.16%
     */
    /*int[] find;
    int minCost = 0;
    int minGate;
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        int[][] distance = new int[(len*(len-1))/2][3];
        find = new int[len+1];
        minGate = len;
        for(int i =0; i <= len; i++) {
            find[i] = i;
        }
        int index = 0;
        for(int i = 0 ; i < len; i++) {
            for(int j = i+1; j < len; j++) {
                int d = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                distance[index][0] = i;
                distance[index][1] = j;
                distance[index][2] = d;
                index += 1;
            }
        }

        Arrays.sort(distance, (a,b) -> a[2] - b[2]);

        kruskal(distance);
        if(minGate == 1) {
            return minCost;
        }

        return -1;
    }


    private void kruskal(int[][] distance) {
        int len = distance.length;

        for(int i = 0; i < len; i++) {

            if(findU(distance[i][0]) != findU(distance[i][1])) {
                minCost += distance[i][2];
                union(distance[i][0], distance[i][1]);
            }
        }
    }

    private int findU(int one) {
        if(find[one] == one)
            return one;
        return find[one] = findU(find[one]);
    }

    private void union(int one, int two) {
        int m1 = findU(one);
        int m2 = findU(two);

        if(m1 != m2)
            find[m1] = m2;
        minGate -= 1;
    }*/

}
