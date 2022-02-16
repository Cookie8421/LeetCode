package com.leetcode.DesignPatterns.src.zyr.dp.factorymethod;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {
	List owners=new ArrayList();
	public Product createProduct(String owner) {
	    System.out.println("Ϊ "+owner+" �����Ʒ�ɹ�...");
		return new IDCardProduct(owner);
	}

	public void registerProduct(Product p) {
	   String owner=((IDCardProduct)p).getOwner();
       owners.add(owner);
       System.out.println("ע�� "+owner+" �Ĳ�Ʒ�ɹ�...");
	}

	public void getAllProductOwner() {
         for(int i=0;i<owners.size();i++){
        	 System.out.println("��Ʒ�û���"+owners.get(i));
         }
	}
}
