package com.leetcode.DesignPatterns.src.zyr.dp.classloader;

public class Child extends Parent{

	public  Child(){
		System.out.println("���๹������ʼ��..."); 
	}
	
    static { 
    	System.out.println("���� ��̬����� ����ʼ��"); 
    }
    
    {System.out.println("���� �Ǿ�̬����� ����ʼ��");}
    
}
