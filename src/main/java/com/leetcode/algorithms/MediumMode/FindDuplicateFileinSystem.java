package com.leetcode.algorithms.MediumMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list paths of directory info, including the directory path, and all the files with contents in this directory, return all the duplicate files in the file system in terms of their paths. You may return the answer in any order.
 *
 * A group of duplicate files consists of at least two files that have the same content.
 *
 * A single directory info string in the input list has the following format:
 *
 *     "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
 *
 * It means there are n files (f1.txt, f2.txt ... fn.txt) with content (f1_content, f2_content ... fn_content) respectively in the directory "root/d1/d2/.../dm". Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.
 *
 * The output is a list of groups of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:
 *
 *     "directory_path/file_name.txt"
 *
 *
 *
 * Example 1:
 *
 * Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
 * Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 *
 * Example 2:
 *
 * Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"]
 * Output: [["root/a/2.txt","root/c/d/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 *
 *
 *
 * Constraints:
 *
 *     1 <= paths.length <= 2 * 104
 *     1 <= paths[i].length <= 3000
 *     1 <= sum(paths[i].length) <= 5 * 105
 *     paths[i] consist of English letters, digits, '/', '.', '(', ')', and ' '.
 *     You may assume no files or directories share the same name in the same directory.
 *     You may assume each given directory info represents a unique directory. A single blank space separates the directory path and file info.
 *
 *
 *
 * Follow up:
 *
 *     Imagine you are given a real file system, how will you search files? DFS or BFS?
 *     If the file content is very large (GB level), how will you modify your solution?
 *     If you can only read the file by 1kb each time, how will you modify your solution?
 *     What is the time complexity of your modified solution? What is the most time-consuming part and memory-consuming part of it? How to optimize?
 *     How to make sure the duplicated files you find are not false positive?
 */
public class FindDuplicateFileinSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        /**
         * Runtime: 44 ms, faster than 73.67% of Java online submissions for Find Duplicate File in System.
         * Memory Usage: 67 MB, less than 81.74% of Java online submissions for Find Duplicate File in System.
         */
        List<List<String>> tempList = new ArrayList<>();
        Map<String,Integer> index = new HashMap<>();
        for(int i = 0; i < paths.length; i++){
            String[] strArr = paths[i].split(" ");
            String path = strArr[0];
            for(int j = 1; j < strArr.length; j++){
                String content = strArr[j].substring(strArr[j].indexOf("(")+1, strArr[j].indexOf(")"));
                if(index.containsKey(content)){
                    List<String> temp = tempList.get(index.get(content));
                    temp.add(path + "/" + strArr[j].substring(0,strArr[j].indexOf("(")));
                } else {
                    index.put(content, tempList.size());
                    List<String> temp = new ArrayList<>();
                    temp.add(path + "/" + strArr[j].substring(0,strArr[j].indexOf("(")));
                    tempList.add(temp);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> list : tempList){
            if(list.size() > 1){
                ans.add(list);
            }
        }
        return ans;
    }

}
