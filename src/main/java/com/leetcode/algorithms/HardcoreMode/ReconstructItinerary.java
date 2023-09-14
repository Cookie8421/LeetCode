package com.leetcode.algorithms.HardcoreMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
 *
 * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 *
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output: ["JFK","MUC","LHR","SFO","SJC"]
 * Example 2:
 *
 *
 * Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 *
 *
 * Constraints:
 *
 * 1 <= tickets.length <= 300
 * tickets[i].length == 2
 * fromi.length == 3
 * toi.length == 3
 * fromi and toi consist of uppercase English letters.
 * fromi != toi
 */
public class ReconstructItinerary {

    /**
     * Runtime
     * 9 ms
     * Beats
     * 36.11%
     * Memory
     * 44.6 MB
     * Beats
     * 43.82%
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();

        // Step 1: Construct the graph
        for (List<String> ticket : tickets) {
            String departure = ticket.get(0);
            String arrival = ticket.get(1);

            graph.putIfAbsent(departure, new ArrayList<>());
            graph.get(departure).add(arrival);
        }

        // Step 3: Sort the lists of destinations
        for (List<String> destinations : graph.values()) {
            Collections.sort(destinations);
        }

        Stack<String> stack = new Stack<>();
        List<String> circuit = new ArrayList<>();

        // Step 6: Push the starting airport to the stack
        stack.push("JFK");

        // Step 7: Perform DFS using stack
        while (!stack.isEmpty()) {
            String current = stack.peek();

            // Step 7b: If current airport has no outgoing edges, add it to the circuit
            if (!graph.containsKey(current) || graph.get(current).isEmpty()) {
                circuit.add(stack.pop());
            } else {
                // Step 7c: Push the next unvisited destination to the stack and remove the edge from the graph
                stack.push(graph.get(current).remove(0));
            }
        }

        // Step 8: Reverse the circuit to get the correct order
        Collections.reverse(circuit);

        return circuit;
    }



}
