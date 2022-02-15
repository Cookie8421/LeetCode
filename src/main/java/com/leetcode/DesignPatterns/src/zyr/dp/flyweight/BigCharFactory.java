package com.leetcode.DesignPatterns.src.zyr.dp.flyweight;

import java.util.HashMap;

public class BigCharFactory {

	private HashMap pool=new HashMap();
	
	private static BigCharFactory bigCharFactory=new BigCharFactory();
	
	private BigCharFactory(){
		
	}
	
	public static BigCharFactory getInstance(){
		return bigCharFactory;
	}
	
	public synchronized BigChar getBigChar(char name){
		BigChar bigchar=(BigChar)pool.get(""+name);
		if(bigchar==null){
			bigchar=new BigChar(name);
			pool.put(""+name, bigchar);
		}
		return bigchar;
	}
	public  BigChar getBigCharNotUsed(char name){
		return new BigChar(name);
	}
	
}
