package com.leetcode.algorithms.MediumMode;

import java.util.*;

/**
 * Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return the answer in any order.
 *
 * If a folder[i] is located within another folder[j], it is called a sub-folder of it.
 *
 * The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.
 *
 *     For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.
 *
 *
 *
 * Example 1:
 *
 * Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * Output: ["/a","/c/d","/c/f"]
 * Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
 *
 * Example 2:
 *
 * Input: folder = ["/a","/a/b/c","/a/b/d"]
 * Output: ["/a"]
 * Explanation: Folders "/a/b/c" and "/a/b/d" will be removed because they are subfolders of "/a".
 *
 * Example 3:
 *
 * Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * Output: ["/a/b/c","/a/b/ca","/a/b/d"]
 *
 *
 *
 * Constraints:
 *
 *     1 <= folder.length <= 4 * 104
 *     2 <= folder[i].length <= 100
 *     folder[i] contains only lowercase letters and '/'.
 *     folder[i] always starts with the character '/'.
 *     Each folder name is unique.
 */
public class RemoveSubFoldersFromTheFilesystem {


    public List<String> removeSubfolders(String[] ar) {
        /**
         * Runtime: 54 ms, faster than 93.53% of Java online submissions for Remove Sub-Folders from the Filesystem.
         * Memory Usage: 75.5 MB, less than 50.00% of Java online submissions for Remove Sub-Folders from the Filesystem.
         */
        Set<String> hs = new HashSet<>();
        List<String> res = new ArrayList<>();
        int n = ar.length;
        for(String val: ar) hs.add(val);
        for(int i=0; i<n; i++){
            String cur = ar[i];
            int len = cur.length();
            boolean add = true;
            for(int j=1; j<len; j++){
                if(cur.charAt(j) != '/') continue;
                String temp = cur.substring(0,j);
                if(hs.contains(temp)) {
                    add = false;
                    break;
                }
            }
            if(add) res.add(cur);
        }
        return res;
    }

    /*public List<String> removeSubfolders(String[] folder) {
        *//**
         * Time Limit Exceeded
         *//*
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder, (a, b) -> a.length() - b.length());
        for(int i = 0; i < folder.length; i++){
            boolean flag = true;
            for(String s : ans){
                if(isSubFolder(folder[i], s)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans.add(folder[i]);
            }
        }
        return ans;
    }

    private boolean isSubFolder(String a, String b){
        String[] arrayA = a.split("/");
        String[] arrayB = b.split("/");
        if(arrayA.length > arrayB.length){
            for(int i = 0; i < arrayB.length; i++){
                if(!arrayA[i].equals(arrayB[i])){
                    return false;
                }
            }
        } else if(arrayA.length == arrayB.length){
            return false;
        }
        return true;
    }*/

}
