package com.leetcode.algorithms.MediumMode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
 *
 * Return a list answer of size 2 where:
 *
 * answer[0] is a list of all players that have not lost any matches.
 * answer[1] is a list of all players that have lost exactly one match.
 * The values in the two lists should be returned in increasing order.
 *
 * Note:
 *
 * You should only consider the players that have played at least one match.
 * The testcases will be generated such that no two matches will have the same outcome.
 *
 *
 * Example 1:
 *
 * Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * Output: [[1,2,10],[4,5,7,8]]
 * Explanation:
 * Players 1, 2, and 10 have not lost any matches.
 * Players 4, 5, 7, and 8 each have lost one match.
 * Players 3, 6, and 9 each have lost two matches.
 * Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].
 * Example 2:
 *
 * Input: matches = [[2,3],[1,3],[5,4],[6,4]]
 * Output: [[1,2,5,6],[]]
 * Explanation:
 * Players 1, 2, 5, and 6 have not lost any matches.
 * Players 3 and 4 each have lost two matches.
 * Thus, answer[0] = [1,2,5,6] and answer[1] = [].
 *
 *
 * Constraints:
 *
 * 1 <= matches.length <= 105
 * matches[i].length == 2
 * 1 <= winneri, loseri <= 105
 * winneri != loseri
 * All matches[i] are unique.
 */
public class FindPlayersWithZeroOrOneLosses {


    /**
     * Runtime
     * 196 ms
     * Memory
     * 141.8 MB
     */
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> winners = new HashMap<>(matches.length );
        HashMap<Integer, Integer> oneLossers = new HashMap<>(matches.length );


        for (int i = 0; i < matches.length; i++) {
            for (int j = 0; j < 1; j++) {
                winners.put(matches[i][0], 1);
                oneLossers.merge(matches[i][1], 1, Integer::sum);
            }
        }
        winners.keySet().removeAll(oneLossers.keySet());
        result.add(winners.keySet().stream().sorted().collect(Collectors.toList()));
        result.add(oneLossers.entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry::getKey).sorted().collect(Collectors.toList()));
        return result;
    }


    /**
     * Runtime
     * 484 ms
     * Memory
     * 102.3 MB
     */
    /*public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        TreeSet<Integer> notLost = new TreeSet<>();
        TreeSet<Integer> lostOnce = new TreeSet<>();
        TreeSet<Integer> other = new TreeSet<>();

        for(int i = 0; i < matches.length; i++){
            int[] tmp = matches[i];
            int winner = tmp[0];
            int loser = tmp[1];
            if(!other.contains(winner)){
                if(!notLost.contains(winner) && !lostOnce.contains(winner)){
                    notLost.add(winner);
                }
            }
            if(!other.contains(loser)){
                if(notLost.contains(loser)){
                    notLost.remove(loser);
                    lostOnce.add(loser);
                } else if(lostOnce.contains(loser)){
                    lostOnce.remove(loser);
                    other.add(loser);
                } else {
                    lostOnce.add(loser);
                }
            } else {
                continue;
            }
        }
        for(Integer i : notLost){
            l1.add(i);
        }
        for(Integer i : lostOnce){
            l2.add(i);
        }
        ans.add(l1);
        ans.add(l2);
        return ans;
    }*/


}
