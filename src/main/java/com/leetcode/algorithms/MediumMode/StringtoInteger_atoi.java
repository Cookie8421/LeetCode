package com.leetcode.algorithms.MediumMode;

import com.google.gson.Gson;
import com.leetcode.Utils.AESUtil;
import com.leetcode.Utils.Encodes;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YHW
 * @ClassName: ValidParentheses
 * @Description:
Implement atoi which converts a string to an integer.
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned.

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * @date 2019/3/3 12:51
 */
public class StringtoInteger_atoi {


    /**
     * @Status:Accepted
     * @Runtime:16 ms
     * @Memory:38.6 MB
     */
    public static int myAtoi(String str) {
        int length = str.length();
        int indexFlag = 0;
        long result = 0;
        boolean sign;
        boolean isPos = true;

        while(indexFlag < length){
            char t = str.charAt(indexFlag);
            switch(t){
                case '+':
                    indexFlag++;sign = true;break;
                case '-':
                    indexFlag++;isPos=false;sign = true;break;
                default:
                    sign = false;
            }
            if(sign || Character.isDigit(t)){
                break;
            }else if(t == ' '){
                indexFlag++;
                continue;
            }else{
                return 0;
            }
        }
        int endFlag = indexFlag;
        while(endFlag < length){
            char t = str.charAt(endFlag);
            if(t < '0' || t > '9') break;
            result = result*10 + (t - '0');
            if(result>Integer.MAX_VALUE) {
                return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            endFlag++;
        }

        return isPos ? (int)result : (int)result * -1;
    }

    public static void main(String[] args){

        System.out.println(myAtoi("2147483648"));

    }
}
