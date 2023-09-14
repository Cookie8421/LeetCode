package com.leetcode.algorithms.Custom.effective.hierarchicalbuilder;

import static com.leetcode.algorithms.Custom.effective.hierarchicalbuilder.NyPizza.Size.*;
import static com.leetcode.algorithms.Custom.effective.hierarchicalbuilder.Pizza.Topping.*;

// Using the hierarchical builder (Page 16)
public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();

        System.out.println(pizza);
        System.out.println(calzone);
    }
}
