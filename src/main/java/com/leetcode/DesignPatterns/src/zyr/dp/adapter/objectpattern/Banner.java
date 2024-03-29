package com.leetcode.DesignPatterns.src.zyr.dp.adapter.objectpattern;

public class Banner {
   private String name;
   public Banner(String name){
	   this.name=name;
   }
   public void showWithParen(){
	   System.out.println("("+name+")");
   }
   public void showWithAster(){
	   System.out.println("*"+name+"*");
   }
}
