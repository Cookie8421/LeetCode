package com.leetcode.algorithms.MediumMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 *
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 *
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 *
 * Example 2:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 *
 * Example 3:
 *
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination:
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 10^5
 *     0 <= pairs.length <= 10^5
 *     0 <= pairs[i][0], pairs[i][1] < s.length
 *     s only contains lower case English letters.
 */
public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        /**
         * Runtime: 63 ms, faster than 70.98% of Java online submissions for Smallest String With Swaps.
         * Memory Usage: 99 MB, less than 67.32% of Java online submissions for Smallest String With Swaps.
         */
        if(pairs.size() == 0)
            return s;
        int len =s.length();
        UnionFind unionFind = new UnionFind(len);
        for(List<Integer> pair : pairs){
            int key = pair.get(0);
            int value = pair.get(1);
            unionFind.union(key,value);
        }
        char[] charArray = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            int x = unionFind.find(i);
            if(map.containsKey(x))
                map.get(x).offer(charArray[i]);
            else
                map.computeIfAbsent(x,key->new PriorityQueue<>()).offer(charArray[i]);
        }
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < len; i++){
            int x = unionFind.find(i);
            builder.append(map.get(x).poll());
        }
        return builder.toString();
    }
    private class UnionFind{
        int[] parent;
        int[] rank;

        UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int key){
            if(key != parent[key])
                parent[key] = find(parent[key]);
            return parent[key];
        }

        void union(int key,int value){
            int rootX = find(key);
            int rootY = find(value);
            if(rootX == rootY)
                return;
            if(rank[rootX] == rank[rootY]){
                parent[rootX] = rootY;
                rank[rootY] ++;
            }else if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }else
                parent[rootY] = rootX;
        }
    }

}
