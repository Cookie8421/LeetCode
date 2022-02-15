package com.leetcode.DesignPatterns.src.zyr.dp.flyweight;

public class Main {

	public static void main(String[] args) {
		String name="221100";
		testMemory( name, false);
		testMemory( name, true);
	}
	public static void testMemory(String name,boolean isUsed){
		System.out.println("是否使用轻量级"+isUsed);
		BigString bs=new BigString(name,isUsed);
		bs.print();
	    countMemory();
	    System.out.println("=================");
	}
	public static void countMemory(){
		Runtime.getRuntime().gc();
		System.out.println("使用内存："+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()));
	}
}
