package com.leetcode.algorithms.EasyMode;

import lombok.var;

import java.util.*;

/**
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
 *
 * A row i is weaker than a row j if one of the following is true:
 *
 *     The number of soldiers in row i is less than the number of soldiers in row j.
 *     Both rows have the same number of soldiers and i < j.
 *
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 *
 *
 *
 * Example 1:
 *
 * Input: mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 2
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 2
 * - Row 4: 5
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 *
 * Example 2:
 *
 * Input: mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 1
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 1
 * The rows ordered from weakest to strongest are [0,2,3,1].
 *
 *
 *
 * Constraints:
 *
 *     m == mat.length
 *     n == mat[i].length
 *     2 <= n, m <= 100
 *     1 <= k <= m
 *     matrix[i][j] is either 0 or 1.
 */
public class TheKWeakestRowsInAMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        /**
         * Runtime: 3 ms, faster than 63.04% of Java online submissions for The K Weakest Rows in a Matrix.
         * Memory Usage: 48.9 MB, less than 36.66% of Java online submissions for The K Weakest Rows in a Matrix.
         */
        HashMap<Integer,Integer> hashMap = new HashMap();
        for(int i = 0; i < mat.length; i++){
            int count = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1){
                    count++;
                } else {
                    break;
                }
            }
            hashMap.put(i,count);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(hashMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        int[] ans = new int[k];
        int j = 0;
        for(Map.Entry map : entryList){
            if(k-- == 0){
                break;
            }
            ans[j++] = (int)map.getKey();
        }
        return ans;


        //Using DP
        /**
         * Runtime: 3 ms, faster than 63.04% of Java online submissions for The K Weakest Rows in a Matrix.
         * Memory Usage: 48.7 MB, less than 62.38% of Java online submissions for The K Weakest Rows in a Matrix.
         */
        /*
        int[] ans=new int[k];
        int[][] dp=new int[mat.length][2];
        int cnt=0;
        for(int i=0;i<mat.length;i++){
            cnt=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    cnt+=1;
                }
            }
            dp[i][0]=i;
            dp[i][1]=cnt;
        }
        Arrays.sort(dp,(a,b)->a[1]-b[1]);
         for(int i=0;i<k;i++){
             ans[i]=dp[i][0];
         }
        return ans;
         */
    }

}
