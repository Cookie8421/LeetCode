package com.leetcode.algorithms.EasyMode;

import lombok.var;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 *
 *
 *
 * Example 1:
 *
 * Input: text = "nlaebolko"
 * Output: 1
 *
 * Example 2:
 *
 * Input: text = "loonbalxballpoon"
 * Output: 2
 *
 * Example 3:
 *
 * Input: text = "leetcode"
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     1 <= text.length <= 104
 *     text consists of lower case English letters only.
 */
public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        /**
         * Runtime: 11 ms, faster than 22.47% of Java online submissions for Maximum Number of Balloons.
         * Memory Usage: 41.9 MB, less than 88.82% of Java online submissions for Maximum Number of Balloons.
         */
        int ans = -1;
        int[] array = new int[5];
        for(int i = 0; i < text.length(); i++){
            Character temp = text.charAt(i);
            if(temp == 'b'){
                array[0]+=1;
            } else if(temp == 'a'){
                array[1]+=1;
            } else if(temp == 'n'){
                array[2]+=1;
            } else if(temp == 'l'){
                array[3]+=1;
            } else if(temp == 'o'){
                array[4]+=1;
            }
        }
        for(int i = 0; i < 3; i++){
            ans = (ans==-1) ? array[i] : Math.min(ans, array[i]);
        }
        for(int i = 3; i < 5; i++){
            ans = Math.min(ans, array[i]/2);
        }
        return ans;


        /**
         * Runtime: 2 ms, faster than 95.96% of Java online submissions for Maximum Number of Balloons.
         * Memory Usage: 42.6 MB, less than 47.92% of Java online submissions for Maximum Number of Balloons.
         */
        /*
        int chars[] = new int[26];
        char ch[] = text.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            chars[ch[i] - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        min = Math.min(min, chars[0]);
        min = Math.min(min, chars[1]);
        min = Math.min(min, chars[11] / 2);
        min = Math.min(min, chars[13]);
        min = Math.min(min, chars[14] / 2);
        return min;
         */
    }

}
