package com.leetcode.algorithms.Custom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author JoeyYoung
 * @ClassName:
 * @Date 2021/11/19 9:32
 * @Description:
 */
public class Java8NewProperty {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("codeIng");
        list.add("coding");
        list.add("Joey1");
        list.add("JoeyYoung");

        String result = list.stream()// 首先将列表转化为Stream流

                .filter( i -> !isNum(i) )// 首先筛选出字母型字符串

                .filter( i -> i.length() >= 5 )// 其次筛选出长度>=5的字符串

                .map( i -> i.toLowerCase() )// 字符串统一转小写

                .distinct()                 // 去重操作来一下

                .sorted( Comparator.naturalOrder() ) // 字符串排序来一下

                .collect( Collectors.joining("❤") ); // 连词成句来一下，完美！


        System.out.println(result);
    }

    private static boolean isNum(String i) {
        char[] charArray = i.toCharArray();
        for(int j = 0; j < charArray.length; j++){
            if(charArray[j] < 65 || (charArray[j] > 90 && charArray[j] < 97) || charArray[j] > 122){
                return true;
            }
        }
        return false;
    }


    /**
     * 解决套娃判空，用Optional
     */
    /*public Integer getScore( Student student ) {

        return Optional.ofNullable(student)

                .map( Student::getSubject )

                .map( Subject::getScore )

                .orElse(null);

    }*/
    /*public String getStreetName( Province province ) {
        return Optional.ofNullable( province )
                .map( i -> i.getCity() )
                .map( i -> i.getDistrict() )
                .map( i -> i.getStreet() )
                .map( i -> i.getName() )
                .orElse( "未找到该道路名" );
    }*/
}
