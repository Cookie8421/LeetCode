package com.leetcode.algorithms.MediumMode;

import com.sun.xml.internal.ws.util.xml.DummyLocation;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;

/**
 * @author YHW
 * @ClassName: Queries on Number of Points Inside a Circle
 * @Description:
 * You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.
 *
 * You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.
 *
 * For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.
 *
 * Return an array answer, where answer[j] is the answer to the jth query.
 *
 **/
public class QueriesOnNumberOfPointsInsideACircle {
    public static void main(String[] args) {
        int[] result = new QueriesOnNumberOfPointsInsideACircle()
                .countPoints(new int[][]{{1,3},{3,3},{5,3},{2,2}}
                        ,new int[][]{{2,3,1},{4,3,1},{1,1,2}});
        int i = 0;
        while (i<result.length){
            System.out.println(result[i++]);
        }

    }

    /**
     *
     * Runtime: 214 ms, faster than 5.08% of Java online submissions for Queries on Number of Points Inside a Circle.
     *  * Memory Usage: 114.5 MB, less than 6.56% of Java online submissions for Queries on Number of Points Inside a Circle.
     */
    /*public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            double q1 = Double.valueOf(queries[i][0]);
            double q2 = Double.valueOf(queries[i][1]);
            for(int j = 0; j < points.length; j++){
                double p1 = Double.valueOf(points[j][0]);
                double p2 = Double.valueOf(points[j][1]);
                double q3 = Double.valueOf(queries[i][2]);
                double pr = Math.sqrt(Math.pow(p1-q1 ,2)+Math.pow(p2-q2 ,2));
                if(pr <= q3){
                    result[i]++;
                }
            }
        }
        return result;
    }*/

    /**
     *
     * java faster than 99.6%
     */
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        int i = 0;
        for (int query[]: queries) {
            int a = query[0];
            int b = query[1];
            int r = query[2];
            int result = 0;
            for (int[] p : points) {
                int x1 = p[0];
                int y1 = p[1];
                if (r * r >= (a-x1)*(a-x1)+ (b-y1)*(b-y1)) {
                    result++;
                }
            }

            ans[i++] = result;
        }
        return ans;
    }
}
