package com.leetcode.algorithms.EasyMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JoeyYoung
 * @ClassName: Pascal's Triangle
 * @Date 2021/12/1 13:49
 * @Description:
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 *
 *
 * Constraints:
 *
 *     1 <= numRows <= 30
 *
 */
public class PascalsTriangle {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
     * Memory Usage: 36.9 MB, less than 77.85% of Java online submissions for Pascal's Triangle.
     */
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0){
            return new ArrayList<>();
        }
        int currentRow = 2;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(1);
        result.add(tmpList);
        tmpList = new ArrayList<>();
        while(result.size() < numRows){
            for(int i = 0; i < currentRow; i++){
                if(i == 0 || i == currentRow - 1){
                    tmpList.add(1);
                    continue;
                }
                tmpList.add(result.get(currentRow-2).get(i-1) + result.get(currentRow-2).get(i));
            }
            if(currentRow < numRows){
                currentRow++;
            }
            result.add(tmpList);
            tmpList = new ArrayList<>();
        }
        return result;
    }

}
