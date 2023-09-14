package com.leetcode.algorithms.Custom.utils;

import com.google.common.io.Files;

import com.leetcode.algorithms.Custom.utils.PictureUtil;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class PictureGen {

    private static void uploadCertificate(){
        String tTradeNo = "JK";
        String path = PictureUtil.HandlerImg("https://test-1304949920.cos.ap-nanjing.myqcloud.com/document/3806586753554182.png",
                "D:/tmp", "评估师AAA", "适老化评估设计师 (一星级)",
                tTradeNo, getTime());

        //生成临时文件
        File file = new File(path);
        byte[] bytes;
        try {
            bytes = Files.toByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private  static String getTime() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        String time = calendar.get(Calendar.YEAR) +"年"+month
                +"月"+ calendar.get(Calendar.DAY_OF_MONTH) +"日";
        return  time;
    }

    public static void main(String[] args) {
        uploadCertificate();
    }
}
