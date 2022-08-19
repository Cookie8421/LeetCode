package com.leetcode.algorithms.EasyMode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Write a program to count the number of days between two dates.
 *
 * The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.
 *
 *
 *
 * Example 1:
 *
 * Input: date1 = "2019-06-29", date2 = "2019-06-30"
 * Output: 1
 *
 * Example 2:
 *
 * Input: date1 = "2020-01-15", date2 = "2019-12-31"
 * Output: 15
 *
 *
 *
 * Constraints:
 *
 *     The given dates are valid dates between the years 1971 and 2100.
 */
public class NumberOfDaysBetweenTwoDates {

    public int daysBetweenDates(String date1, String date2) {
        /**
         * Runtime: 1 ms, faster than 99.42% of Java online submissions for Number of Days Between Two Dates.
         * Memory Usage: 40 MB, less than 99.42% of Java online submissions for Number of Days Between Two Dates.
         */
        return Math.abs(getDays(date1) - getDays(date2));
    }

    private static int getDays(String s){
        int y = Integer.parseInt(s.substring(0, 4));
        int m = Integer.parseInt(s.substring(5, 7));
        int d = Integer.parseInt(s.substring(8, 10));
        int[] prefix = new int[]{0, 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 2; i <= 13; i++) prefix[i] += prefix[i - 1];
        int ans = (y - 1971) * 365 + prefix[m] + d;
        for (int i = 1972; i < y; i+=4)
            if (isLeap(i))
                ans++;
        if (isLeap(y) && m > 2) ans++; //don't include this within the for loop because m > 2 for it to count.

        return ans;
    }

    private static boolean isLeap(int y){
        return y % 4 == 0 && (y % 100 != 0 || y % 400 == 0);
    }


}
