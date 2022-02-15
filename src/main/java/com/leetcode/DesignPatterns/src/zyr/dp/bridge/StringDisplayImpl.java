package com.leetcode.DesignPatterns.src.zyr.dp.bridge;

public class StringDisplayImpl extends DisplayImpl {

	String name;
	public StringDisplayImpl(String name){
		this.name=name;
	}
	
	public void rawOpen() {
		printline();
	}

	public void rawPrint() {
		System.out.println("|||||"+name+"|||||");
	}

	public void rawClose() {
		printline();
	}
	private void printline(){
		System.out.println("================");
	}

}
