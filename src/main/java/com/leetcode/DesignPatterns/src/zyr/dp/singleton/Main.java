package com.leetcode.DesignPatterns.src.zyr.dp.singleton;

public class Main {

	public static void main(String[] args) {
    
		Singleton object1= Singleton.getInstance();
		Singleton object2= Singleton.getInstance();
		if(object1==object2){
			 System.out.println("��ͬһ������...");
		}else{
			 System.out.println("����ͬһ������...");
		}
	}
	
}
