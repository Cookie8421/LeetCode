package com.leetcode.algorithms.Custom.nettyLearning.Http;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

/**
 * netty server
 * 2018/11/1.
 */
public class HttpServer {

    int port ;

    public HttpServer(int port){
        this.port = port;
    }

    public void start() throws Exception{
        ServerBootstrap bootstrap = new ServerBootstrap();
        //EventLoopGroup 的实现用来处理不同的传输。在这个例子中我们实现了一个服务端的应用，
        // 因此会有 2 个 NioEventLoopGroup 会被使用。第一个经常被叫做‘boss’，用来接收进来的连接。
        // 第二个经常被叫做‘worker’，用来处理已经被接收的连接，一旦‘boss’接收到连接，就会把连接信息注册到‘worker’上。
        // 如何知道多少个线程已经被使用，如何映射到已经创建的 Channel上都需要依赖于 EventLoopGroup 的实现，
        // 并且可以通过构造函数来配置他们的关系。
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            bootstrap.group(boss,work)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HttpServerInitializer())
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = bootstrap.bind(new InetSocketAddress(port)).sync();
            System.out.println(" server start up on port : " + port);
            f.channel().closeFuture().sync();
        } finally {
            //关闭一个 Netty 应用往往只需要简单地通过 shutdownGracefully() 方法来关闭你构建的所有的 EventLoopGroup。
            // 当 EventLoopGroup 被完全地终止,并且对应的所有 channel 都已经被关闭时，Netty 会返回一个Future对象来通知你。
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        HttpServer server = new HttpServer(8090);
        server.start();
    }

}
