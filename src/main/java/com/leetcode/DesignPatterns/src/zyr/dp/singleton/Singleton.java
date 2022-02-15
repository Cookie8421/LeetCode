package com.leetcode.DesignPatterns.src.zyr.dp.singleton;

public class Singleton {
   private  static  Singleton singleton=new Singleton();

   private Singleton(){
	   System.out.println("��ʼ��ʼ������...");
   }
   public static Singleton getInstance(){
	   return singleton;
   }
}
