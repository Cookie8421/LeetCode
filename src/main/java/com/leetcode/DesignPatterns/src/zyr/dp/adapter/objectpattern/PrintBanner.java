package com.leetcode.DesignPatterns.src.zyr.dp.adapter.objectpattern;

public class PrintBanner extends Print {

	Banner banner;
	public PrintBanner(String name) {
		banner=new Banner(name);
	}

	public void printWeak() {
		System.out.println("...��ʼ������...");
		banner.showWithParen();
		System.out.println("...������ɹ�...");
		System.out.println();
	}

	public void printStrong() {
		System.out.println("...��ʼǿ����...");
		banner.showWithAster();
		System.out.println("...ǿ����ɹ�...");
		System.out.println();
	}
}
