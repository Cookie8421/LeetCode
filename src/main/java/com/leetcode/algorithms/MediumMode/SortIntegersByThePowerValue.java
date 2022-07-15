package com.leetcode.algorithms.MediumMode;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The power of an integer x is defined as the number of steps needed to transform x into 1 using the following steps:
 *
 *     if x is even then x = x / 2
 *     if x is odd then x = 3 * x + 1
 *
 * For example, the power of x = 3 is 7 because 3 needs 7 steps to become 1 (3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1).
 *
 * Given three integers lo, hi and k. The task is to sort all integers in the interval [lo, hi] by the power value in ascending order,
 * if two or more integers have the same power value sort them by ascending order.
 *
 * Return the kth integer in the range [lo, hi] sorted by the power value.
 *
 * Notice that for any integer x (lo <= x <= hi) it is guaranteed that x will transform into 1 using these steps and that the power of x is will fit in a 32-bit signed integer.
 *
 *
 *
 * Example 1:
 *
 * Input: lo = 12, hi = 15, k = 2
 * Output: 13
 * Explanation: The power of 12 is 9 (12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1)
 * The power of 13 is 9
 * The power of 14 is 17
 * The power of 15 is 17
 * The interval sorted by the power value [12,13,14,15].
 * For k = 2 answer is the second element which is 13.
 * Notice that 12 and 13 have the same power value and we sorted them in ascending order.
 * Same for 14 and 15.
 *
 * Example 2:
 *
 * Input: lo = 7, hi = 11, k = 4
 * Output: 7
 * Explanation: The power array corresponding to the interval [7, 8, 9, 10, 11] is [16, 3, 19, 6, 14].
 * The interval sorted by power is [8, 10, 11, 7, 9].
 * The fourth number in the sorted array is 7.
 *
 *
 *
 * Constraints:
 *
 *     1 <= lo <= hi <= 1000
 *     1 <= k <= hi - lo + 1
 */
public class SortIntegersByThePowerValue {

    /**
     * Runtime: 77 ms, faster than 73.95% of Java online submissions for Sort Integers by The Power Value.
     * Memory Usage: 47.9 MB, less than 52.27% of Java online submissions for Sort Integers by The Power Value.
     */
    public int getKth(int lo, int hi, int k) {
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

        for (int i = lo; i <= hi; i++) {
            int power = getPower(i);
            if (!map.containsKey(power))
                map.put(power, new ArrayList<>());
            map.get(power).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            for (int i : e.getValue()) {
                ans.add(i);
            }
        }
        return ans.get(k - 1);
    }

    public int getPower(int i) {
        int count = 0;
        while (i != 1) {
            if (i % 2 == 0) i = i / 2;
            else i = 3 * i + 1;
            count++;
        }
        return count;
    }

    /*public int getKth(int lo, int hi, int k) {
        int[] resArr = new int[hi-lo+1];
        int[] indexArr = new int[hi-lo+1];
        int currentIndex = 0;
        int min = 1000;
        for(int i = lo; i <= hi; i++){
            resArr[currentIndex] = getPower(i);
            indexArr[currentIndex++] = i;
        }
        for(int i = 0; i < hi-lo; i++){
            int index = i;
            for(int j = i; j <= hi-lo; j++){
                if(resArr[j] < min){
                    min = resArr[j];
                    index = j;
                }
            }
            //swap
            int t = indexArr[i];
            indexArr[i] = indexArr[index];
            indexArr[index] = t;
            t = resArr[i];
            resArr[i] = resArr[index];
            resArr[index] = t;
            min = 1000;

        }
        return indexArr[k-1];
    }

    public int getPower(int cur){
        if(cur == 1){
            return 1;
        }
        if(cur%2 == 0) {
            return 1 + getPower(cur / 2);
        } else {
            return 1 + getPower(3*cur+1);
        }
    }*/

}
