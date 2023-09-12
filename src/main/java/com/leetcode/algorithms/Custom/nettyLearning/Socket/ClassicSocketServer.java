package com.leetcode.algorithms.Custom.nettyLearning.Socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClassicSocketServer {

    public static void main(String[] args) {
        int port = 4343; //端口号
        // Socket 服务器端（简单的发送信息）
        Thread sThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(port);
                    while (true) {
                        // 等待连接
                        Socket socket = serverSocket.accept();
                        Thread sHandlerThread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream())) {
                                    printWriter.println("hello world！");
                                    printWriter.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        sHandlerThread.start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        sThread.start();
    }

}


