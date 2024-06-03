package com.leetcode.algorithms.Custom;

import java.math.BigDecimal;

public class ValueTransportTest {

    public static void helper1(BigDecimal value){
        value = value.add(new BigDecimal(1));
    }

    public static BigDecimal helper2(BigDecimal value){
        value = value.add(new BigDecimal(1));
        return value;
    }

    public static void main(String[] args) {
        BigDecimal value = new BigDecimal(1);
        helper1(value);
        System.out.println(value);
        System.out.println(helper2(value));
        System.out.println(value);
    }
}
