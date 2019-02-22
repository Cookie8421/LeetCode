package com.leetcode.algorithms.EasyMode;

/**
 * @author YHW
 * @ClassName: LongestCommonPrefix
 * @Description:
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * @date 2019/2/22 9:31
 */
public class LongestCommonPrefix {

    /**
     * @Status:Accepted
     * @Runtime:4 ms
     * @Memory:38 MB
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int strsMinLength = strs[0].length();
        boolean flag = false;
        for(int i = 0; i < strs.length-1; i++){
            if(strs[i+1].length() < strsMinLength) {
                strsMinLength = strs[i+1].length();
            }
        }
        for(int i = 0; i < strsMinLength; i++){
            char temp = strs[0].charAt(i);
            for(int j = 0; j < strs.length; j++){
                if(strs[j].charAt(i) != temp){
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
            sb.append(temp);

        }
        return sb.toString();

    }

    public static void main(String[] args){
        String[] strs = {"aa", "a"};
        System.out.println(longestCommonPrefix(strs));
    }
}
