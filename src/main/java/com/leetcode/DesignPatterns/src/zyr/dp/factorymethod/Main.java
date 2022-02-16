package com.leetcode.DesignPatterns.src.zyr.dp.factorymethod;

public class Main {

	public static void main(String[] args) {
      Factory f=new IDCardFactory();
      Product p=f.create("������");
      p.use();   
      System.out.println("--------------------");
      p=f.create("��ɽ��");
      p.use();
      System.out.println("--------------------");
      f.getAllProductOwner();
	}

}
