package com.leetcode.algorithms.MediumMode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YHW
 * @ClassName: AddTwoNumbers
 * @Description:
 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
 * For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 *
 * Given a string n that represents a positive decimal integer,
 * return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 * @date 2019/6/1 15:13
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    /**
     * Runtime: 88 ms, faster than 7.95% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
     * Memory Usage: 97 MB, less than 5.80% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
     *
     */
    public int minPartitions(String n) {
        char[] tmp = n.toCharArray();
        int count = 0;
        int maxNum = 0;
        for(int i = 0; i < tmp.length; i++){
            if(maxNum  == 9){
                return 9;
            }
            if(count <= 9){
                count += Integer.parseInt(Character.toString(tmp[i]));
            }
            if(Integer.parseInt(Character.toString(tmp[i])) > maxNum){
                maxNum = Integer.parseInt(Character.toString(tmp[i]));
            }
        }
        return Math.min(maxNum, count);
    }

    /**
     *
     * Runtime: 9 ms, faster than 52.67% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
     * Memory Usage: 51.4 MB, less than 36.20% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
     *
     * public int minPartitions(String n) {
     *         if(n.contains("9")) return 9;
     *         if(n.contains("8")) return 8;
     *         if(n.contains("7")) return 7;
     *         if(n.contains("6")) return 6;
     *         if(n.contains("5")) return 5;
     *         if(n.contains("4")) return 4;
     *         if(n.contains("3")) return 3;
     *         if(n.contains("2")) return 2;
     *         if(n.contains("1")) return 1;
     *         return 0;
     *     }
     */

    public static void main(String[] args) {
        PartitioningIntoMinimumNumberOfDeciBinaryNumbers p = new PartitioningIntoMinimumNumberOfDeciBinaryNumbers();
        System.out.println(p.minPartitions("32"));
    }
}
