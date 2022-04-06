package com.leetcode.algorithms.MediumMode;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @author JoeyYoung
 * @version 1.0.0
 * @ClassName InsertInterval
 * @Description
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 *
 * Constraints:
 *
 *     0 <= intervals.length <= 104
 *     intervals[i].length == 2
 *     0 <= starti <= endi <= 105
 *     intervals is sorted by starti in ascending order.
 *     newInterval.length == 2
 *     0 <= start <= end <= 105
 * @createTime 2022/4/2 14:33
 */
public class InsertInterval {

    /**
     * Runtime: 1 ms, faster than 98.78% of Java online submissions for Insert Interval.
     * Memory Usage: 47.4 MB, less than 72.93% of Java online submissions for Insert Interval.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List < int[] > list = new ArrayList();
        if (intervals.length == 0 || newInterval[1] < intervals[0][0]) {
            list.add(newInterval);
            int itr = 0;
            while (itr < intervals.length) {
                list.add(intervals[itr++]);
            }
        } else {
            int itr = 0;
            // before merge
            while (itr < intervals.length && intervals[itr][1] < newInterval[0]) {
                list.add(intervals[itr++]);
            }
            int[] last;
            // merging
            if (itr < intervals.length) {
                if (intervals[itr][1] < newInterval[0]) {
                    list.add(intervals[itr]);
                    last = newInterval;
                } else if (newInterval[1] < intervals[itr][0]) {
                    list.add(newInterval);
                    last = intervals[itr];
                } else {
                    last = new int[] {
                            Math.min(newInterval[0], intervals[itr][0]),
                            Math.max(newInterval[1], intervals[itr][1])
                    };
                }

            } else {
                last = newInterval;
            }

            // after merge
            for (int i = itr + 1; i < intervals.length; i++) {
                if (intervals[i][0] <= last[1]) {
                    last[1] = Math.max(intervals[i][1], last[1]);
                } else {
                    list.add(last);
                    last = intervals[i];
                }
            }

            list.add(last);
        }


        int[][] result = new int[list.size()][2];
        int itr = 0;
        for (int[] arr: list)
            result[itr++] = arr;

        return result;
    }

}
