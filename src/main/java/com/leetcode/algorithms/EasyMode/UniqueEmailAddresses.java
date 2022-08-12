package com.leetcode.algorithms.EasyMode;

import java.util.HashSet;
import java.util.Set;

/**
 * Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.
 *
 *     For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
 *
 * If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.
 *
 *     For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 *
 * If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.
 *
 *     For example, "m.y+name@email.com" will be forwarded to "my@email.com".
 *
 * It is possible to use both of these rules at the same time.
 *
 * Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.
 *
 *
 *
 * Example 1:
 *
 * Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
 *
 * Example 2:
 *
 * Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
 * Output: 3
 *
 *
 *
 * Constraints:
 *
 *     1 <= emails.length <= 100
 *     1 <= emails[i].length <= 100
 *     emails[i] consist of lowercase English letters, '+', '.' and '@'.
 *     Each emails[i] contains exactly one '@' character.
 *     All local and domain names are non-empty.
 *     Local names do not start with a '+' character.
 *     Domain names end with the ".com" suffix.
 */
public class UniqueEmailAddresses {


    public int numUniqueEmails(String[] emails) {
        /**
         * Runtime: 50 ms, faster than 22.25% of Java online submissions for Unique Email Addresses.
         * Memory Usage: 55.7 MB, less than 5.72% of Java online submissions for Unique Email Addresses.
         */
        /*int length = emails.length;
        Set<String> res = new HashSet<>();
        // remove "."
        for(int i = 0; i < length; i++){
            StringBuilder stringBuilder = new StringBuilder();
            String[] arr = emails[i].split("@");
            String temp = arr[0].replaceAll("\\.","");
            temp = temp.replaceAll("\\+\\S+","");
            res.add(stringBuilder.append(temp).append("@").append(arr[1]).toString());
        }
        return res.size();*/

        /**
         * Runtime: 15 ms, faster than 83.66% of Java online submissions for Unique Email Addresses.
         * Memory Usage: 45.5 MB, less than 83.59% of Java online submissions for Unique Email Addresses.
         */
        HashSet hs = new HashSet<>();
        for(int i=0;i<emails.length;i++){
            StringBuilder sb = new StringBuilder();
            String email=emails[i];
            for(int j=0;j<email.length();j++){
                if(email.charAt(j)=='.')
                    continue;
                else if(email.charAt(j)=='+'){
                    while(email.charAt(j+1)!='@')
                        j++;
                }
                else if(email.charAt(j)=='@'){
                    sb.append(email,j,email.length());
                    j=email.length();
                    break;
                }
                else
                    sb.append(email.charAt(j));
            }
            hs.add(sb.toString());
        }
        return hs.size();
    }



}
