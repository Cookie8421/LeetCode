package com.leetcode.algorithms.Custom;

import java.util.List;

public class CombineLists {

    /**
     * combine multiple list of String
     */
    public void CombineLists(List<List<String>> list){
        helper(list, 0, "");
    }

    public void helper(List<List<String>> list, int index, String str){
        List<String> current = list.get(index);
        if(index == list.size()-1){
            for(String s : current){
                System.out.println(str+s);
            }
        } else {
            for(String s : current){
                helper(list, index+1, str+s);
            }
        }
    }

}
