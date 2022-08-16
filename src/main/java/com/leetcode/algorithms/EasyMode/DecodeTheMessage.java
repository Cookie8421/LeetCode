package com.leetcode.algorithms.EasyMode;

import java.util.HashSet;

/**
 * You are given the strings key and message, which represent a cipher key and a secret message, respectively. The steps to decode message are as follows:
 *
 *     Use the first appearance of all 26 lowercase English letters in key as the order of the substitution table.
 *     Align the substitution table with the regular English alphabet.
 *     Each letter in message is then substituted using the table.
 *     Spaces ' ' are transformed to themselves.
 *
 *     For example, given key = "happy boy" (actual key would have at least one instance of each letter in the alphabet), we have the partial substitution table of ('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f').
 *
 * Return the decoded message.
 *
 *
 *
 * Example 1:
 *
 * Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
 * Output: "this is a secret"
 * Explanation: The diagram above shows the substitution table.
 * It is obtained by taking the first appearance of each letter in "the quick brown fox jumps over the lazy dog".
 *
 * Example 2:
 *
 * Input: key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
 * Output: "the five boxing wizards jump quickly"
 * Explanation: The diagram above shows the substitution table.
 * It is obtained by taking the first appearance of each letter in "eljuxhpwnyrdgtqkviszcfmabo".
 *
 *
 *
 * Constraints:
 *
 *     26 <= key.length <= 2000
 *     key consists of lowercase English letters and ' '.
 *     key contains every letter in the English alphabet ('a' to 'z') at least once.
 *     1 <= message.length <= 2000
 *     message consists of lowercase English letters and ' '.
 */
public class DecodeTheMessage {

    public String decodeMessage(String key, String message) {
        /**
         * Runtime: 11 ms, faster than 38.44% of Java online submissions for Decode the Message.
         * Memory Usage: 44.4 MB, less than 24.59% of Java online submissions for Decode the Message.
         */
        char[] res = message.toCharArray();
        char[] alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] temp = new char[26];
        int index = 0;
        HashSet hashSet = new HashSet();
        for(int i = 0; i < key.length(); i++){
            if(key.charAt(i) != ' ' && !hashSet.contains(key.charAt(i))){
                temp[index++] = key.charAt(i);
                hashSet.add(key.charAt(i));
            }
        }
        for(int i = 0; i < message.length(); i++){
            if(res[i] == ' '){
                continue;
            }
            res[i] = alphabet[String.valueOf(temp).lastIndexOf(res[i])];
        }
        return String.valueOf(res);


        //Using HashMap:
        /**
         * Runtime: 7 ms, faster than 60.94% of Java online submissions for Decode the Message.
         * Memory Usage: 42.9 MB, less than 49.18% of Java online submissions for Decode the Message.
         */
        /*
        HashMap<Character, Character> map = new HashMap<>();
        char base = 'a';
        int count = 0;
        for (char c : key.toCharArray()) {
            if (c != ' ' && !map.containsKey(c)) {
                map.put(c, base++);
                count ++;
            }
            if (count >= 26) {
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c != ' ') {
                c = map.get(c);
            }
            builder.append(c);
        }
        return builder.toString();
         */
    }

}
