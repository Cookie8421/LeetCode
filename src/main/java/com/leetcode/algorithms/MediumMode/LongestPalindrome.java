package com.leetcode.algorithms.MediumMode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author YHW
 * @ClassName: LongestPalindrome
 * @Description:
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * @date 2019/2/25 11:03
 */
public class LongestPalindrome {


    public static String longestPalindrome(String s) {
        int length = s.length();
        Palindrome pa = null;
        if(length == 0){
            return "";
        }else if(length == 1){
            return s;
        }else if(length == 2){
            if(s.charAt(0) == s.charAt(1)){
                return s;
            }else{
                return s.substring(1);
            }
        }else if(length == 3){
            if(s.charAt(0) == s.charAt(2)){
                return s;
            }else if(s.charAt(0) == s.charAt(1)){
                return s.substring(0, 2);
            }else if(s.charAt(1) == s.charAt(2)){
                return s.substring(1, 3);
            }else{
                return "";
            }
        }

        for(int i = 1 ; i < length - 1; i++){
            int startIndex = i - 1;
            int endIndex = i + 1;
            boolean isEve;
            if(s.charAt(startIndex) == s.charAt(endIndex)){
                isEve = false;
            }else{
                isEve = true;
            }
            if(isEve){
                if(s.charAt(startIndex) != s.charAt(i) && s.charAt(endIndex) == s.charAt(i)){
                    if(endIndex < length){
                        endIndex ++;
                    }
                }
                if(s.charAt(startIndex) == s.charAt(i) && s.charAt(endIndex) != s.charAt(i)){
                    if(startIndex > 0){
                        startIndex --;
                    }
                }else{
                    continue;
                }
            }
            while(s.charAt(startIndex) == s.charAt(endIndex)){
                if(startIndex > 0 && endIndex < length){
                    startIndex --;
                    endIndex ++;
                }else{
                    if(pa == null){
                        pa = new Palindrome(startIndex, endIndex);
                        break;
                    }else{
                        Palindrome pal = new Palindrome(startIndex, endIndex);
                        if(pal.length > pa.length){
                            pa = pal;
                            break;
                        }
                    }

                }
            }
        }
        if(pa == null){
            return s.substring(length - 1);
        }
        return s.substring(pa.start, pa.end + 1);
    }
    static class Palindrome{
        int start;
        int end;
        int length;

        Palindrome(int start, int end){
            this.start = start;
            this.end = end;
            this.length = end - start + 1;
        }

    }
    public static void main(String[] args){
        System.out.println(longestPalindrome("aaaa"));
    }

    /**
     *
     * @Description:时间复杂度为o(n*n),很差的算法,而且当字符串很大，容易内存溢出
     */
    /*public static String longestPalindrome(String s) {
        int length = s.length();
        int offset = length - 1;
        Stack stack = new Stack();

        if(length == 0){
            return "";
        }else if(length == 1){
            return s;
        }

        while(offset != 0){
            int startIndex = 0;
            int endIndex = startIndex + offset;
            while(endIndex < length){
                int i = startIndex;
                for(; i <= endIndex; i++){
                    stack.push(s.charAt(i));
                }
                for(i = startIndex; i < endIndex; i++){
                    if(s.charAt(i) != (char)stack.pop()){
                        break;
                    }
                }
                if(i == endIndex){
                    return s.substring(startIndex, endIndex + 1);
                }else{
                    startIndex++;
                    endIndex++;
                    stack.empty();
                }
            }
            offset --;
        }
        return s.substring(length - 1);
    }*/

}
