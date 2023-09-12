package com.leetcode.algorithms.Custom.IOLearning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileReadAndWrite {

    /*public void readAndWrite(String filePath) {
        //IO
        // 添加文件
        FileWriter fileWriter = new FileWriter(filePath, true);
        fileWriter.write(Content);
        fileWriter.close();

        // 读取文件
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer bf = new StringBuffer();
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            bf.append(str + "\n");
        }
        bufferedReader.close();
        fileReader.close();
        System.out.println(bf.toString());


        //NIO
        // 写入文件（追加方式：StandardOpenOption.APPEND）
        Files.write(Paths.get(filePath), Content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

        // 读取文件
        byte[] data = Files.readAllBytes(Paths.get(filePath));
        System.out.println(new String(data, StandardCharsets.UTF_8));

        // 创建多（单）层目录（如果不存在创建，存在不会报错）
        new File("D://a//b").mkdirs();
    }*/

}
