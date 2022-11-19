package com.leetcode.algorithms.MediumMode;

import java.util.Arrays;

/**
 * You are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1].
 *
 * You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:
 *
 * The first element in s[k] starts with the selection of the element nums[k] of index = k.
 * The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
 * We stop adding right before a duplicate element occurs in s[k].
 * Return the longest length of a set s[k].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
 * One of the longest sets s[k]:
 * s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}
 * Example 2:
 *
 * Input: nums = [0,1,2]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] < nums.length
 * All the values of nums are unique.
 */
public class ArrayNesting {


    /**
     * Runtime
     * 23 ms
     * Memory
     * 81.4 MB
     */
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);

        int ans = 0;

        for(int i = 0; i < n; i++) {
            uf.unite(i, nums[i]);
            ans = Math.max(ans, uf.size(i));
        }

        return ans;

        /**
         * Runtime
         * 6 ms
         * Memory
         * 75.1 MB
         *
         *
         *      int count,max=0;
         *         for(int i=0;i<nums.length;i++){
         *           count=0;
         *             int index=i;
         *             while(nums[index]!=-999){
         *                 int temp=nums[index];
         *                 nums[index]=-999;
         *                 index=temp;
         *                 count++;
         *             }
         *           max=Math.max(count,max);
         *       }
         *         return max;
         */
    }

    class UnionFind {
        private int[] root;

        public UnionFind(int n) {
            root = new int[n];
            Arrays.fill(root, -1);
        }

        public int find(int x) {
            if(root[x] < 0) {
                return x;
            }

            // path compression
            return root[x] = find(root[x]);
        }

        public void unite(int x, int y) {
            x = find(x);
            y = find(y);

            if(x == y) {
                return;
            }

            // Union by size
            if(size(x) < size(y)) {
                root[y] += root[x];
                root[x] = y;
            } else {
                root[x] += root[y];
                root[y] = x;
            }
        }

        public int size(int x) {
            return -root[find(x)];
        }
    }
}
