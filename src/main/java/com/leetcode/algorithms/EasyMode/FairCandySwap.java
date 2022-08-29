package com.leetcode.algorithms.EasyMode;

import java.util.HashSet;

/**
 * Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number of candies of the jth box of candy that Bob has.
 *
 * Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have the same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each box they have.
 *
 * Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange, and answer[1] is the number of candies in the box that Bob must exchange. If there are multiple answers, you may return any one of them. It is guaranteed that at least one answer exists.
 *
 * Example 1:
 *
 * Input: aliceSizes = [1,1], bobSizes = [2,2]
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: aliceSizes = [1,2], bobSizes = [2,3]
 * Output: [1,2]
 *
 * Example 3:
 *
 * Input: aliceSizes = [2], bobSizes = [1,3]
 * Output: [2,3]
 *
 *
 *
 * Constraints:
 *
 *     1 <= aliceSizes.length, bobSizes.length <= 104
 *     1 <= aliceSizes[i], bobSizes[j] <= 105
 *     Alice and Bob have a different total number of candies.
 *     There will be at least one valid answer for the given input.
 */
public class FairCandySwap {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        /**
         * Time Limit Exceeded
         */
        int[] ans = new int[2];
        HashSet<Integer> aliceSet = new HashSet();
        HashSet<Integer> bobSet = new HashSet();
        int aliceSum = 0;
        int bobSum = 0;
        for(int i = 0; i < aliceSizes.length; i++){
            aliceSet.add(aliceSizes[i]);
            aliceSum+=aliceSizes[i];
        }
        for(int i = 0; i < bobSizes.length; i++){
            bobSet.add(bobSizes[i]);
            bobSum+=bobSizes[i];
        }
        int interval = (aliceSum - bobSum) / 2;
        for(Integer i : aliceSet){
            for(Integer j : bobSet){
                if(i - j == interval){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;


        /**
         * Runtime: 15 ms, faster than 89.87% of Java online submissions for Fair Candy Swap.
         * Memory Usage: 69.6 MB, less than 26.37% of Java online submissions for Fair Candy Swap.
         */
        /*
            int totalA=0;
            int totalB=0;

            for(int a:aliceSizes){
                totalA = totalA + a;
            }

            Set<Integer> set = new HashSet<>();
            for(int b:bobSizes){
                totalB = totalB + b;
                set.add(b);
            }

            int delta = (totalB-totalA)/2;
            int ans[] = new int[2];
            for(int a:aliceSizes){
                if(set.contains(delta+a)){
                    ans[0]=a;
                    ans[1]=delta+a;
                    break;
                }
            }

            return ans;
         */
    }

}
