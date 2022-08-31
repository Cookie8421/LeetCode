package com.leetcode.algorithms.EasyMode;

/**
 * Given a date string in the form Day Month Year, where:
 *
 *     Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
 *     Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
 *     Year is in the range [1900, 2100].
 *
 * Convert the date string to the format YYYY-MM-DD, where:
 *
 *     YYYY denotes the 4 digit year.
 *     MM denotes the 2 digit month.
 *     DD denotes the 2 digit day.
 *
 *
 *
 * Example 1:
 *
 * Input: date = "20th Oct 2052"
 * Output: "2052-10-20"
 *
 * Example 2:
 *
 * Input: date = "6th Jun 1933"
 * Output: "1933-06-06"
 *
 * Example 3:
 *
 * Input: date = "26th May 1960"
 * Output: "1960-05-26"
 *
 *
 *
 * Constraints:
 *
 *     The given dates are guaranteed to be valid, so no error handling is necessary.
 */
public class ReformatDate {

    public String reformatDate(String date) {
        /**
         * Runtime: 1 ms, faster than 99.63% of Java online submissions for Reformat Date.
         * Memory Usage: 42.8 MB, less than 24.38% of Java online submissions for Reformat Date.
         */
        String[] month = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        StringBuilder stringBuilder = new StringBuilder();
        String[] dateArr = date.split(" ");
        stringBuilder.append(dateArr[2]).append("-");
        for(int i = 0; i < month.length; i++){
            if(dateArr[1].equals(month[i])){
                if(i < 9){
                    stringBuilder.append(0);
                }
                stringBuilder.append(i+1).append("-");
            }
        }
        if(dateArr[0].charAt(1) <= '9'){
            stringBuilder.append(dateArr[0].charAt(0));
            stringBuilder.append(dateArr[0].charAt(1));
        } else {
            stringBuilder.append(0).append(dateArr[0].charAt(0));
        }
        return stringBuilder.toString();
    }

}
