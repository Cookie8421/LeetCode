package com.leetcode.algorithms.EasyMode;

public class ExcelSheetColumnTitle {

    /**
     * Runtime
     * 0 ms
     * Beats
     * 100%
     * Memory
     * 39.4 MB
     */
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}
