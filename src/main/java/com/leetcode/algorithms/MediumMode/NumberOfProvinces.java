package com.leetcode.algorithms.MediumMode;

/**
 * @Author JoeyYoung
 * @ClassName: Number of Provinces
 * @Date 2021/11/20 14:47
 * @Description:
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c,
 * then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
 * and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 *
 * Constraints:
 *
 *     1 <= n <= 200
 *     n == isConnected.length
 *     n == isConnected[i].length
 *     isConnected[i][j] is 1 or 0.
 *     isConnected[i][i] == 1
 *     isConnected[i][j] == isConnected[j][i]
 */

public class NumberOfProvinces {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Provinces.
     * Memory Usage: 39.9 MB, less than 61.16% of Java online submissions for Number of Provinces.
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length ;
        boolean vis[] = new boolean[n] ;
        int ans=0 ;
        for(int i=0 ; i<n ; i++){
            if(!vis[i]){
                ans++ ;
                dfs(i , vis , isConnected) ;
            }
        }return ans ;
    }
    public void dfs(int node , boolean[] vis , int[][] g){
        vis[node]=true ;
        for(int i=0 ; i<g.length ; i++){
            if(!vis[i] && g[node][i]==1)dfs(i , vis , g) ;
        }
    }
}
