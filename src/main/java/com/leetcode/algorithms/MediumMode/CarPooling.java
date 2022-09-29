package com.leetcode.algorithms.MediumMode;

/**
 * There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
 *
 * You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.
 *
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 *
 * Example 2:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 *
 *
 *
 * Constraints:
 *
 *     1 <= trips.length <= 1000
 *     trips[i].length == 3
 *     1 <= numPassengersi <= 100
 *     0 <= fromi < toi <= 1000
 *     1 <= capacity <= 105
 */
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        /**
         * Runtime: 4 ms, faster than 72.60% of Java online submissions for Car Pooling.
         * Memory Usage: 44.4 MB, less than 67.71% of Java online submissions for Car Pooling.
         */
        int[] temp = new int[1001];
        int max = 0;
        for(int i = 0; i < trips.length; i++){
            max = Math.max(trips[i][1], max);
            max = Math.max(trips[i][2], max);
            temp[trips[i][1]]+=trips[i][0];
            temp[trips[i][2]]-=trips[i][0];
        }
        int count = 0;
        for(int i = 0; i <= max; i++){
            count += temp[i];
            if(count > capacity){
                return false;
            }
        }
        return true;
    }

}
