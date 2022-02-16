package com.leetcode.DesignPatterns.src.zyr.dp.factorymethod;

public class IDCardProduct extends Product {

	String owner;
    IDCardProduct(String owner){
    	this.owner=owner;
    }
	public void use() {
      System.out.println("�û� "+owner+" ����ʹ�ò�Ʒ...");
	}
    public String getOwner() {
		return owner;
	}
}
