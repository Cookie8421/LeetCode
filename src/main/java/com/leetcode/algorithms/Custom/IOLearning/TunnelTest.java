package com.leetcode.algorithms.Custom.IOLearning;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TunnelTest {

    public static void test1() throws Exception {
        // 利用通道完成文件的复制(非直接缓冲区)
        FileInputStream fis = new FileInputStream("a.txt");
        FileOutputStream fos = new FileOutputStream("b.txt");
        // 获取通道
        FileChannel fisChannel = fis.getChannel();
        FileChannel foschannel = fos.getChannel();

        // 通道没有办法传输数据，必须依赖缓冲区
        // 分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 将通道中的数据存入缓冲区中
        while (fisChannel.read(byteBuffer) != -1) {  // fisChannel 中的数据读到 byteBuffer 缓冲区中
            byteBuffer.flip();  // 切换成读数据模式
            // 将缓冲区中的数据写入通道
            foschannel.write(byteBuffer);
            byteBuffer.clear();  // 清空缓冲区
        }
        foschannel.close();
        fisChannel.close();
        fos.close();
        fis.close();
    }

    public static void test2() throws Exception {
        // 使用直接缓冲区完成文件的复制(内存映射文件)
        /**
         * 使用 open 方法来获取通道
         * 需要两个参数
         * 参数1：Path 是 JDK1.7 以后给我们提供的一个类，代表文件路径
         * 参数2：Option  就是针对这个文件想要做什么样的操作
         *      --StandardOpenOption.READ ：读模式
         *      --StandardOpenOption.WRITE ：写模式
         *      --StandardOpenOption.CREATE ：如果文件不存在就创建，存在就覆盖
         */
        FileChannel inChannel = FileChannel.open(Paths.get("a.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("c.txt"), StandardOpenOption.WRITE,
                StandardOpenOption.READ, StandardOpenOption.CREATE);

        /**
         * 内存映射文件
         * 这种方式缓冲区是直接建立在物理内存之上的
         * 所以我们就不需要通道了
         */
        MappedByteBuffer inMapped = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapped = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        // 直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMapped.limit()];
        inMapped.get(dst);  // 把数据读取到 dst 这个字节数组中去
        outMapped.put(dst); // 把字节数组中的数据写出去

        inChannel.close();
        outChannel.close();
    }

    public static void test3() throws Exception {
        /**
         * 通道之间的数据传输（直接缓冲区的方式）
         * transferFrom
         * transferTo
         */
        FileChannel inChannel = FileChannel.open(Paths.get("a.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("d.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);
        inChannel.transferTo(0, inChannel.size(), outChannel);
        // 或者可以使用下面这种方式
        //outChannel.transferFrom(inChannel, 0, inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    public static void test4() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("a.txt", "rw");
        // 获取通道
        FileChannel channel = raf.getChannel();
        // 分配指定大小缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(2);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        // 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel.read(bufs);  // 参数需要一个数组
        for (ByteBuffer byteBuffer : bufs) {
            byteBuffer.flip();  // 切换到读模式
        }
        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));  // 打印 he
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));  // 打印 llo

        // 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("e.txt","rw");
        // 获取通道
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);  // 把 bufs 里面的几个缓冲区聚集到 channel2 这个通道中，聚集到通道中，也就是到了 e.txt 文件中
        channel2.close();
    }

}
