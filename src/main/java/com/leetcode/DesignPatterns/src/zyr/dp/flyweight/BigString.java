package com.leetcode.DesignPatterns.src.zyr.dp.flyweight;

public class BigString {

	private BigChar [] bigchars;
	public BigString(String word,boolean isUsed){
		if(isUsed == true){
			bigchars=new BigChar[word.length()];
			BigCharFactory bf=BigCharFactory.getInstance();
			for(int i=0;i<word.length();i++){
				bigchars[i]=bf.getBigChar(word.charAt(i));
			}
		}else{
			bigchars=new BigChar[word.length()];
			BigCharFactory bf=BigCharFactory.getInstance();
			for(int i=0;i<word.length();i++){
				bigchars[i]=bf.getBigCharNotUsed(word.charAt(i));
			}
		}
	}

	public void print(){
		for(int i=0;i<bigchars.length;i++){
			bigchars[i].print();
		}
	}
}
