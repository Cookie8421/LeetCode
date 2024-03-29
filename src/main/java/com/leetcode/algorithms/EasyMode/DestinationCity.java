package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
 *
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 *
 *
 *
 * Example 1:
 *
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
 *
 * Example 2:
 *
 * Input: paths = [["B","C"],["D","B"],["C","A"]]
 * Output: "A"
 * Explanation: All possible trips are:
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * Clearly the destination city is "A".
 *
 * Example 3:
 *
 * Input: paths = [["A","Z"]]
 * Output: "Z"
 *
 *
 *
 * Constraints:
 *
 *     1 <= paths.length <= 100
 *     paths[i].length == 2
 *     1 <= cityAi.length, cityBi.length <= 10
 *     cityAi != cityBi
 *     All strings consist of lowercase and uppercase English letters and the space character.
 */
public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        /**
         * Runtime: 5 ms, faster than 37.96% of Java online submissions for Destination City.
         * Memory Usage: 43.5 MB, less than 75.25% of Java online submissions for Destination City.
         */
        HashMap<String,String> hashMap = new HashMap();
        List<String> des = new ArrayList<>();
        for(List<String> list : paths){
            String from = list.get(0);
            String destination = list.get(1);
            if(hashMap.containsKey(from)){
                if(hashMap.get(from).equals("D")){
                    hashMap.replace(from, "F");
                    des.remove(from);
                }
            } else {
                hashMap.put(from, "F");
            }
            if(!hashMap.containsKey(destination)){
                hashMap.put(destination, "D");
                des.add(destination);
            }
        }
        return des.get(0);


        /**
         * Runtime: 4 ms, faster than 57.93% of Java online submissions for Destination City.
         * Memory Usage: 44 MB, less than 43.05% of Java online submissions for Destination City.
         */
        /*
        HashMap<String,String> mp  =  new HashMap<>();

        for(List<String> p: paths){
            mp.put(p.get(0), p.get(1));
        }

        String dest  = paths.get(0).get(0);
        while(mp.containsKey(dest))
        {
            dest  =  mp.get(dest);
        }
        return dest;
         */
    }

}
