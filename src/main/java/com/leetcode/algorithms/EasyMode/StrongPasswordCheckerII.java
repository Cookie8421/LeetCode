package com.leetcode.algorithms.EasyMode;

/**
 * A password is said to be strong if it satisfies all the following criteria:
 *
 *     It has at least 8 characters.
 *     It contains at least one lowercase letter.
 *     It contains at least one uppercase letter.
 *     It contains at least one digit.
 *     It contains at least one special character. The special characters are the characters in the following string: "!@#$%^&*()-+".
 *     It does not contain 2 of the same character in adjacent positions (i.e., "aab" violates this condition, but "aba" does not).
 *
 * Given a string password, return true if it is a strong password. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: password = "IloveLe3tcode!"
 * Output: true
 * Explanation: The password meets all the requirements. Therefore, we return true.
 *
 * Example 2:
 *
 * Input: password = "Me+You--IsMyDream"
 * Output: false
 * Explanation: The password does not contain a digit and also contains 2 of the same character in adjacent positions. Therefore, we return false.
 *
 * Example 3:
 *
 * Input: password = "1aB!"
 * Output: false
 * Explanation: The password does not meet the length requirement. Therefore, we return false.
 *
 *
 *
 * Constraints:
 *
 *     1 <= password.length <= 100
 *     password consists of letters, digits, and special characters: "!@#$%^&*()-+".
 */
public class StrongPasswordCheckerII {

    public boolean strongPasswordCheckerII(String password) {
        /**
         * Runtime: 3 ms, faster than 34.11% of Java online submissions for Strong Password Checker II.
         * Memory Usage: 42 MB, less than 62.96% of Java online submissions for Strong Password Checker II.
         */
        int res = 0b0000;
        if(password.length() < 8){
            return false;
        }
        int temp = password.charAt(0);
        for(int i = 0; i < password.length(); i++){
            if(password.charAt(i) >= 97 && password.charAt(i) <= 122){
                res = res | 0b1000;
            }
            if(password.charAt(i) >= 65 && password.charAt(i) <= 90){
                res = res | 0b0100;
            }
            if(password.charAt(i) >= 48 && password.charAt(i) <= 57){
                res = res | 0b0010;
            }
            if("!@#$%^&*()-+".contains(String.valueOf(password.charAt(i)))){
                res = res | 0b0001;
            }
            if(i > 0 && password.charAt(i) == temp){
                return false;
            }
            temp = password.charAt(i);
        }
        if(res == 0b1111){
            return true;
        } else {
            return false;
        }


        /*
        static final int[] MASK_MAP = new int[128]; // enough to cover 7-bit ASCII and input constraints
        static final int LOWER = 1;
        static final int UPPER = 2;
        static final int DIGIT = 4;
        static final int SPECIAL = 8;
        static final int COVERED = (LOWER | UPPER | DIGIT | SPECIAL);

        static {
            for (int i = 0; i < 26; ++i) {
                MASK_MAP['a' + i] = LOWER;
                MASK_MAP['A' + i] = UPPER;
            }
            for (int i = 0; i < 10; ++i) {
                MASK_MAP['0' + i] = DIGIT;
            }
            for (char ch : "!@#$%^&*()-+".toCharArray()) {
                MASK_MAP[(int) ch] = SPECIAL;
            }
        }

        public boolean strongPasswordCheckerII(String password) {
            if (password.length() < 8) {
                return false; // not length 8
            }
            char last = (char) 0; // (char) 0 is not valid input, so won't match password[0]
            int coverage = 0;
            for (int i = 0; i < password.length(); ++i) {
                final char ch = password.charAt(i);
                if (ch == last) {
                    return false; // two consecutive of the same character
                }
                coverage |= MASK_MAP[(int) ch]; // track our coverage of the four character classes
                last = ch;
            }
            return (coverage == COVERED); // true if all four character classes are covered
        }
         */
    }

}
