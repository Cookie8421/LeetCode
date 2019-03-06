package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YHW
 * @ClassName: ValidParentheses
 * @Description:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * @date 2019/3/2 9:31
 */

public class ZigZagConversion {

    /**
     * @Status:Accepted
     * @Runtime:23 ms
     * @Memory:41.5 MB
     */
    public static String convert(String s, int numRows) {
        int interval = 2 * (numRows - 1);
        int length = s.length();
        int column = (length - length % numRows) / numRows + length % numRows;
        List indexcache = new  ArrayList(column);
        StringBuilder result = new StringBuilder(length);
        int offset = 0;

        if(numRows == 1){
            return s;
        }if(numRows == 2){
            for(int i = 0; i < 2; i++){
                int current = i;
                while(current < length){
                    indexcache.add(current);
                    current += 2;
                }
                for(Object item : indexcache){
                    result.append(s.charAt((int) item));
                }
                indexcache.clear();
            }
            return result.toString();
        }
        for(int i = 0; i <= interval / 2; i++){
            int current = i;
            while(true){
                if(current >= length){
                    break;
                }
                if(offset == 0){
                    indexcache.add(current);
                    current += interval;
                    continue;
                }else if(offset == interval){
                    indexcache.add(current);
                    current += interval;
                    continue;
                }else{
                    indexcache.add(current);
                    current += interval;
                    if(current - offset == i){
                        continue;
                    }else if(current - offset >= length){
                        continue;
                    }else{
                        indexcache.add(current - offset);
                    }
                }
            }
            for(Object item : indexcache){
                result.append(s.charAt((int) item));
            }
            indexcache.clear();
            offset += 2;
        }
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(convert("AIUWBNDIURTPY", 2));
    }
}
