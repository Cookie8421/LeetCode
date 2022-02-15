package com.leetcode.DesignPatterns.src.zyr.dp.singleton;

public class SingletonLazy {
   private  static  SingletonLazy singletonLazy=null;

   private SingletonLazy(){
	   System.out.println("��ʼ��ʼ������...");
   }
//   public static synchronized SingletonLazy getInstance(){
//	   if(singletonLazy==null){
//		   return new SingletonLazy();
//	   }
//	   return singletonLazy;
//   }
   
   public static  SingletonLazy getInstance(){
	   if (singletonLazy == null) {    
	       synchronized (Singleton.class) {    
	          if (singletonLazy == null) {    
	        	  singletonLazy = new SingletonLazy();   
	          }    
	       }    
	   }    
	   return singletonLazy;
   }
   

}
