package com.leetcode.algorithms.Custom.nettyLearning.Socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

    public static void main(String[] args) {
        InputStreamReader isr;
        BufferedReader br;
        OutputStreamWriter osw;
        BufferedWriter bw;
        String str;
        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 8899);
            System.out.println("成功连接服务器");
            while (true) {
                osw = new OutputStreamWriter(socket.getOutputStream());
                bw = new BufferedWriter(osw);
                System.out.print("客户端发送:");
                str = in.nextLine();
                bw.write(str + "\n");
                bw.flush();
                isr = new InputStreamReader(socket.getInputStream());
                br = new BufferedReader(isr);
                System.out.println("服务端回复:" + br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
