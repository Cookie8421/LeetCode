package com.leetcode.DesignPatterns.src.zyr.dp.bridge;

public  class CountDisplay extends Display {

	public CountDisplay(DisplayImpl displayImpl) {
		super(displayImpl);
	}
	public final void mutilDisplay(){
		open();
		for(int i=0;i<5;i++){
			print();
		}
		close();
	}
	
}
