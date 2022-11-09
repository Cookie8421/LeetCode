package com.leetcode.algorithms.MediumMode;

/**
 * Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
 *
 * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
 *
 * The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).
 *
 *
 *
 * Example 1:
 *
 * Rectangle Area
 * Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * Output: 45
 * Example 2:
 *
 * Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * Output: 16
 *
 *
 * Constraints:
 *
 * -104 <= ax1 <= ax2 <= 104
 * -104 <= ay1 <= ay2 <= 104
 * -104 <= bx1 <= bx2 <= 104
 * -104 <= by1 <= by2 <= 104
 */
public class RectangleArea {


    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        /**
         * Runtime
         * 243 ms
         * Memory
         * 43.7 MB
         */
        /*int sum = (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1);
        if(bx1>=ax2 || by1>=ay2 || ax1>=bx2 || ay1>=by2){
            return sum;
        } else {
            return sum - (Math.min(bx2,ax2) - Math.max(bx1,ax1))*(Math.min(by2,ay2) - Math.max(by1,ay1));
        }*/


        /**
         * 3ms
         */
        int a1 = Math.abs((ax2 - ax1) * (ay2 - ay1));
        int a2 = Math.abs((bx2 - bx1) * (by2 - by1));
        boolean intersect = Math.max(ax1, bx1) < Math.min(bx2, ax2) && Math.max(ay1, by1) < Math.min(ay2, by2);
        int overlap = Math.abs((Math.min(bx2, ax2) - Math.max(ax1, bx1)) * (Math.min(ay2, by2) - Math.max(ay1, by1)));
        // !empty area && intersect
        return a1 + a2 - ((a1 != 0 && a2 != 0 && intersect) ? overlap : 0);
    }


}
