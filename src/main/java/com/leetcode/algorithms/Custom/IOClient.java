package com.leetcode.algorithms.Custom;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class IOClient {
    public static void main(String[] args) {
        // TODO 创建多个线程，模拟多个客户端连接服务端
        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("Thread-%d")
                .setDaemon(true).build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5, 7, 30,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(10), threadFactory);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Socket socket = new Socket("127.0.0.1", 3333);
                    while (true) {
                        try {
                            socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                            Thread.sleep(500);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
