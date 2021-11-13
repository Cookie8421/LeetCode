package com.leetcode.algorithms.MediumMode;

import java.util.Stack;

/**
 * @Author JoeyYoung
 * @ClassName: Simplify Path
 * @Date 2021/11/13 9:45
 * @Description:
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 *     The path starts with a single slash '/'.
 *     Any two directories are separated by a single slash '/'.
 *     The path does not end with a trailing '/'.
 *     The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 *
 * Return the simplified canonical path.
 *
 * Example 1:
 *
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 */
public class SimplifyPath {

    /**
     * Runtime: 4 ms, faster than 78.73% of Java online submissions for Simplify Path.
     * Memory Usage: 39.2 MB, less than 54.04% of Java online submissions for Simplify Path.
     */
    public static String simplifyPath(String path) {
        Stack<String> tmpStack = new Stack<>();
        String[] strArray = path.split("/");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < strArray.length; i++){
            if(strArray[i].equals("") || strArray[i].equals(".")){
                continue;
            } else if(strArray[i].equals("..")){
                if(!tmpStack.isEmpty()){
                    tmpStack.pop();
                }
            } else {
                tmpStack.push(strArray[i]);
                continue;
            }
        }
        if(tmpStack.isEmpty()){
            return "/";
        }
        while(!tmpStack.isEmpty()){
            if(!tmpStack.isEmpty()){
                result.insert(0,tmpStack.pop());
            }
            result.insert(0, "/");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = simplifyPath(new String("/../"));
        System.out.println(str);
    }
}


