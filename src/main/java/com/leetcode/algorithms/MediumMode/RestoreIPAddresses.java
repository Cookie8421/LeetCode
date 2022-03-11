package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.List;


/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 *     For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 *
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s.
 * You are not allowed to reorder or remove any digits in s.
 * You may return the valid IP addresses in any order.
 *
 *
 */
public class RestoreIPAddresses {

    private static List<String> resultList = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {
        recursion(s.substring(0, s.length() - 1), String.valueOf(s.charAt(s.length() - 1)), 3, resultList);
        return resultList;
    }

    /**
     * Runtime: 44 ms, faster than 5.43% of Java online submissions for Restore IP Addresses.
     * Memory Usage: 49.1 MB, less than 5.09% of Java online submissions for Restore IP Addresses.
     */
    private static void recursion(String remain, String result, int index, List<String> resultList){
        if(index == 3){
            if(remain.length() < 3){
                return;
            }
            recursion(remain.substring(0, remain.length()), "." + result, index - 1, resultList);
            recursion(remain.substring(0, remain.length() - 1), "." + remain.charAt(remain.length() - 1) + result, index - 1, resultList);
            recursion(remain.substring(0, remain.length() - 2), "." + remain.charAt(remain.length() - 2) + remain.charAt(remain.length() - 1) + result, index - 1, resultList);
        } else if(index == 2){
            if(remain.length() < 2){
                return;
            }
            String s = result.split("\\.")[1];
            if(Integer.parseInt(s) > 255 || (s.length() > 1 && s.charAt(0) == '0')){
                return;
            }
            try{
                recursion(remain.substring(0, remain.length() - 1), "." + remain.charAt(remain.length() - 1) + result, index - 1, resultList);
                recursion(remain.substring(0, remain.length() - 2), "." + remain.charAt(remain.length() - 2) + remain.charAt(remain.length() - 1) + result, index - 1, resultList);
                recursion(remain.substring(0, remain.length() - 3), "." + remain.charAt(remain.length() - 3) + remain.charAt(remain.length() - 2) + remain.charAt(remain.length() - 1) + result, index - 1, resultList);
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(index == 1){
            if(remain.length() < 1){
                return;
            }
            String s = result.split("\\.")[1];
            if(Integer.parseInt(s) > 255 || (s.length() > 1 && s.charAt(0) == '0')){
                return;
            }
            try{
                recursion(remain.substring(0, remain.length() - 1), "." + remain.charAt(remain.length() - 1) + result, index - 1, resultList);
                recursion(remain.substring(0, remain.length() - 2), "." + remain.charAt(remain.length() - 2) + remain.charAt(remain.length() - 1) + result, index - 1, resultList);
                recursion(remain.substring(0, remain.length() - 3), "." + remain.charAt(remain.length() - 3) + remain.charAt(remain.length() - 2) + remain.charAt(remain.length() - 1) + result, index - 1, resultList);
            } catch(Exception e){
                e.printStackTrace();
                return;
            }
        } else if(index == 0){
            if(remain.length() < 1
                    || remain.length() > 3
                    || Integer.parseInt(remain) > 255){
                return;
            }
            String s = result.split("\\.")[1];
            if(Integer.parseInt(s) > 255 || (s.length() > 1 && s.charAt(0) == '0')){
                return;
            }
            if(remain.length() > 1 && remain.charAt(0) == '0'){
                return;
            }
            resultList.add(remain + result);
        }
    }

    public static void main(String[] args) {
        restoreIpAddresses("101023");
        for(String item : resultList){
            System.out.println(item);
        }

    }
}
