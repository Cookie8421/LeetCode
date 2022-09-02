package com.leetcode.algorithms.MediumMode;

import java.util.HashSet;

/**
 * On an infinite plane, a robot initially stands at (0, 0) and faces north. Note that:
 *
 *     The north direction is the positive direction of the y-axis.
 *     The south direction is the negative direction of the y-axis.
 *     The east direction is the positive direction of the x-axis.
 *     The west direction is the negative direction of the x-axis.
 *
 * The robot can receive one of three instructions:
 *
 *     "G": go straight 1 unit.
 *     "L": turn 90 degrees to the left (i.e., anti-clockwise direction).
 *     "R": turn 90 degrees to the right (i.e., clockwise direction).
 *
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 *
 *
 *
 * Example 1:
 *
 * Input: instructions = "GGLLGG"
 * Output: true
 * Explanation: The robot is initially at (0, 0) facing the north direction.
 * "G": move one step. Position: (0, 1). Direction: North.
 * "G": move one step. Position: (0, 2). Direction: North.
 * "L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: West.
 * "L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: South.
 * "G": move one step. Position: (0, 1). Direction: South.
 * "G": move one step. Position: (0, 0). Direction: South.
 * Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (0, 2) --> (0, 1) --> (0, 0).
 * Based on that, we return true.
 *
 * Example 2:
 *
 * Input: instructions = "GG"
 * Output: false
 * Explanation: The robot is initially at (0, 0) facing the north direction.
 * "G": move one step. Position: (0, 1). Direction: North.
 * "G": move one step. Position: (0, 2). Direction: North.
 * Repeating the instructions, keeps advancing in the north direction and does not go into cycles.
 * Based on that, we return false.
 *
 * Example 3:
 *
 * Input: instructions = "GL"
 * Output: true
 * Explanation: The robot is initially at (0, 0) facing the north direction.
 * "G": move one step. Position: (0, 1). Direction: North.
 * "L": turn 90 degrees anti-clockwise. Position: (0, 1). Direction: West.
 * "G": move one step. Position: (-1, 1). Direction: West.
 * "L": turn 90 degrees anti-clockwise. Position: (-1, 1). Direction: South.
 * "G": move one step. Position: (-1, 0). Direction: South.
 * "L": turn 90 degrees anti-clockwise. Position: (-1, 0). Direction: East.
 * "G": move one step. Position: (0, 0). Direction: East.
 * "L": turn 90 degrees anti-clockwise. Position: (0, 0). Direction: North.
 * Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (-1, 1) --> (-1, 0) --> (0, 0).
 * Based on that, we return true.
 *
 *
 *
 * Constraints:
 *
 *     1 <= instructions.length <= 100
 *     instructions[i] is 'G', 'L' or, 'R'.
 */
public class RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions) {
        /**
         * Runtime: 14 ms, faster than 5.15% of Java online submissions for Robot Bounded In Circle.
         * Memory Usage: 45.7 MB, less than 5.98% of Java online submissions for Robot Bounded In Circle.
         */
        int count = 0;
        String current = "0,0";
        String origin = current;
        int currentDirection = 0;
        while(count < 4){
            for(int i = 0; i < instructions.length(); i++){
                String[] currentArr = current.split(",");
                if(instructions.charAt(i) == 'G'){
                    if(currentDirection == 0){
                        currentArr[1] = String.valueOf(Integer.parseInt(currentArr[1]) + 1);
                    } else if(currentDirection == 1){
                        currentArr[0] = String.valueOf(Integer.parseInt(currentArr[0]) + 1);
                    } else if(currentDirection == 2){
                        currentArr[1] = String.valueOf(Integer.parseInt(currentArr[1]) - 1);
                    } else if(currentDirection == 3){
                        currentArr[0] = String.valueOf(Integer.parseInt(currentArr[0]) - 1);
                    }
                    current = currentArr[0] + "," + currentArr[1];
                } else if(instructions.charAt(i) == 'L'){
                    currentDirection = (currentDirection-1+4)%4;
                } else if(instructions.charAt(i) == 'R'){
                    currentDirection = (currentDirection+1+4)%4;
                }
            }
            if(origin.equals(current)){
                return true;
            }
            count++;
        }
        return false;


        /**
         * Runtime: 1 ms, faster than 76.04% of Java online submissions for Robot Bounded In Circle.
         * Memory Usage: 41.7 MB, less than 75.06% of Java online submissions for Robot Bounded In Circle.
         */
        /*
        int x = 0;
        int y = 0;
        int d = 0;

        for(char c : instructions.toCharArray()) {
            if(c == 'L') {
                d-=90;
                if(d <0) {
                    d+= 360;
                }
            }
            else if(c == 'R') {
                d += 90;
                d = d %360;
            }
            else {
                if (d == 0) {
                   y++;
                }
                else if(d == 90) {
                    x++;
                }
                else if(d == 180) {
                    y--;
                }
                else {
                    x--;
                }
            }

        }
        return (x ==0 && y==0) ||(d != 0);
         */
    }
}
