package com.leetcode.DesignPatterns.src.zyr.dp.bridge;

public class Main {
	
	public static void main(String[] args) {
		Display display = new Display(new StringDisplayImpl("������"));
		display.display();
		CountDisplay cd = new CountDisplay(new StringDisplayImpl("��ɽ��"));
		cd.display();
		cd.mutilDisplay();
	}
}
