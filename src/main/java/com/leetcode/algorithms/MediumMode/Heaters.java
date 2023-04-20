package com.leetcode.algorithms.MediumMode;

import java.util.Arrays;

/**
 * Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
 *
 * Every house can be warmed, as long as the house is within the heater's warm radius range.
 *
 * Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
 *
 * Notice that all the heaters follow your radius standard, and the warm radius will the same.
 *
 *
 *
 * Example 1:
 *
 * Input: houses = [1,2,3], heaters = [2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * Example 2:
 *
 * Input: houses = [1,2,3,4], heaters = [1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 * Example 3:
 *
 * Input: houses = [1,5], heaters = [2]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= houses.length, heaters.length <= 3 * 104
 * 1 <= houses[i], heaters[i] <= 109
 */
public class Heaters {

    /**
     * Sort+Two Pointers
     * Runtime
     * 13 ms
     * Memory
     * 46.1 MB
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int l = 0;
        int r = 0;
        while(l < houses.length){
            if(r == heaters.length-1){
                res = Math.max(Math.abs(houses[l] - heaters[r]), res);
                l++;
            } else {
                if(houses[l] < heaters[r]){
                    res = Math.max(res, heaters[r] - houses[l]);
                    l++;
                } else if(houses[l] == heaters[r]){
                    l++;
                } else {
                    if(houses[l] < heaters[r+1]){
                        res = Math.max(res, Math.min(houses[l] - heaters[r],heaters[r+1] - houses[l]));
                        l++;
                    } else if(houses[l] == heaters[r]){
                        l++;
                    } else {
                        r++;
                    }
                }
            }
        }
        return res;
    }

}
