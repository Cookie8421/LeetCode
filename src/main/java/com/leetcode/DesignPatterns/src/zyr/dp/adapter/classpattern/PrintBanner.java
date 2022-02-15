package com.leetcode.DesignPatterns.src.zyr.dp.adapter.classpattern;

public class PrintBanner extends Banner implements Print {

	public PrintBanner(String name) {
		super(name);
	}

	public void printWeak() {
		System.out.println("...��ʼ������...");
		showWithParen();
		System.out.println("...������ɹ�...");
		System.out.println();
	}

	public void printStrong() {
		System.out.println("...��ʼǿ����...");
		showWithAster();
		System.out.println("...ǿ����ɹ�...");
		System.out.println();
	}
}
