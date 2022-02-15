package com.leetcode.DesignPatterns.src.zyr.dp.builder;

public class Director {
	private Builder builder;
	public Director(Builder builder){
		this.builder=builder;
	}
	public void construct(){
		String [] items1=new String[]{"�����","������"};
		String [] items2=new String[]{"���ڹ���","������"};
		builder.makeTitle("����ͷ��");
		builder.makeString("��ҵ����");
		builder.makeItems(items1);
		builder.makeString("�������");
		builder.makeItems(items2);
		builder.close();
	}
}
