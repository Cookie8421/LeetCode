package com.leetcode.algorithms.EasyMode;

import java.util.HashSet;

/**
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
 *
 * Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: path = "NES"
 * Output: false
 * Explanation: Notice that the path doesn't cross any point more than once.
 *
 * Example 2:
 *
 * Input: path = "NESWW"
 * Output: true
 * Explanation: Notice that the path visits the origin twice.
 *
 *
 *
 * Constraints:
 *
 *     1 <= path.length <= 104
 *     path[i] is either 'N', 'S', 'E', or 'W'.
 */
public class PathCrossing {

    class Point{

        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Point){
               if(((Point) obj).x == this.x && ((Point) obj).y == this.y){
                   return true;
               }
            }
            return false;
        }

        @Override
        public int hashCode(){
            return (7*this.x)*7 + this.y;
        }
    }

    public boolean isPathCrossing(String path) {
        /**
         * Runtime: 2 ms, faster than 87.82% of Java online submissions for Path Crossing.
         * Memory Usage: 42.4 MB, less than 77.72% of Java online submissions for Path Crossing.
         */
        HashSet<Point> hashSet = new HashSet();
        hashSet.add(new Point(0,0));
        Point current = new Point(0,0);
        for(int i = 0; i < path.length(); i++){
            if(path.charAt(i) == 'N'){
                current.y++;
            } else if(path.charAt(i) == 'S'){
                current.y--;
            } else if(path.charAt(i) == 'W'){
                current.x--;
            } else if(path.charAt(i) == 'E'){
                current.x++;
            }
            if(hashSet.contains(current)){
                return true;
            } else {
                hashSet.add(current);
            }
        }
        return false;
    }

}
