package com.leetcode.algorithms.EasyMode;

import java.nio.charset.StandardCharsets;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 *
 *
 *
 * Example 1:
 *
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 *
 * Example 2:
 *
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 *
 *
 * Constraints:
 *
 *     The given address is a valid IPv4 address.
 */
public class DefangingAnIPAddress {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Defanging an IP Address.
     * Memory Usage: 42.1 MB, less than 36.76% of Java online submissions for Defanging an IP Address.
     */
    public String defangIPaddr(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = address.length();
        char[] a = address.toCharArray();
        for(int i = 0; i < length; i++){
            if(a[i] != '.'){
                stringBuilder.append(a[i]);
            } else {
                stringBuilder.append("[.]");
            }
        }
        return stringBuilder.toString();
    }
}
