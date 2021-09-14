package com.leetcode.algorithms.Custom;

public class EnumTest {
    public static void main(String[] args) {
        Pizza pz = new Pizza();
        pz.setStatus(Pizza.PizzaStatus.READY);
        pz.deliver();
        assert(pz.getStatus() == Pizza.PizzaStatus.DELIVERED);


        System.out.println(PinType.FORGET_PASSWORD.getCode());
        System.out.println(PinType.FORGET_PASSWORD.getMessage());
        System.out.println(PinType.FORGET_PASSWORD.toString());
    }
}
