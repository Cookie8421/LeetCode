package com.leetcode.DesignPatterns.src.zyr.dp.classloader;

public class Parent {

	protected static final String familyName = "������";
	
	public  Parent(){
		System.out.println("���๹������ʼ��..."); 
	}
    
    static { 
    	System.out.println("���� ��̬����� ����ʼ��"); 
    }
    { System.out.println("���� �Ǿ�̬����� ����ʼ��");}
}
