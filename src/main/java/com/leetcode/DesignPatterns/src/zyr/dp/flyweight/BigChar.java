package com.leetcode.DesignPatterns.src.zyr.dp.flyweight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {

	private char charname;
	private String frontData;
	public BigChar(char charname){
		this.charname=charname;
		try {
			BufferedReader br=new BufferedReader(new FileReader("D:\\BaiduNetdiskDownload\\DesignPattern\\FlyWeightPattern\\" + "big"+charname+".txt"));
			StringBuffer sb=new StringBuffer();
			String line;
			while((line=br.readLine())!=null){
				sb.append(line+"\n");
			}
			br.close();
			frontData=sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void print(){
		System.out.println(frontData);
	}
}
