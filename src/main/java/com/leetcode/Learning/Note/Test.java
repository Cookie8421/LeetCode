package com.leetcode.Learning.Note;


import com.leetcode.algorithms.EasyMode.PalindromeNumber;
import com.leetcode.algorithms.MediumMode.*;
import org.apache.commons.lang3.ArrayUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        /*PermutationsII p = new PermutationsII();
        List<List<Integer>> result = p.permuteUnique(new int[]{2,2,1,1});
        for(List<Integer> item : result){
            for(Integer i : item){
                System.out.print(i);
            }
            System.out.println("");
        }*/

        /*PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(110));*/

        /*ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0});
        for(List<Integer> item : result){
            for(Integer i : item){
                System.out.print(i);
            }
            System.out.println(" ");
        }

        String phone = "18061029873";
        System.out.println(phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1####$2"));
        System.out.println(String.format("%s:%s" , "aaaa", "configKey"));

        String url = "http://www.baidu.com/aaa.pcm";
        StringBuilder sb = new StringBuilder();
        sb.append("user_").append(url.substring(url.lastIndexOf("/") + 1, url.length() - 4)).append(".dat");
        System.out.println(sb.toString());

        Pattern pattern = Pattern.compile("[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}");
        Matcher matcher = pattern.matcher("00:0E:A9:2E:09:A1");
        System.out.println(matcher.matches());

        String dateStart = "2013-02-19 09:29:58";
        String dateStop = "2013-02-19 11:31:48";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);
        }catch(ParseException e){
            e.printStackTrace();
        }
        long diff = d2.getTime() - d1.getTime(); //毫秒
        long diffMinutes = diff / (60 * 1000); //分钟

        System.out.println(diffMinutes);

        String[] strArr = new String[]{"a", "b", "c"};
        System.out.println(Arrays.stream(strArr).collect(Collectors.joining(",")));
        */
        /*String[] s = "the     sky is    blue".split("\\s+");
        for(int i = 0; i < s.length; i++){
            System.out.println(s[i] + "!");
        }*/
        /*int[][] l = new int[][]{{7,17},{8,4},{9,20},{10,7},{11,15}};
        Arrays.sort(l, (a, b) -> (a[1] != b[1]) ? a[1] - b[1] : a[0] - b[0]);
        System.out.println(l[2][0]);*/
    }
}
