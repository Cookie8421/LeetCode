package com.leetcode.algorithms.Custom.nettyLearning;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import java.sql.Time;

/**
 * ChannelInitializer 是一个特殊的处理类，他的目的是帮助使用者配置一个新的 Channel。
 * 也许你想通过增加一些处理类比如 DiscardServerHandler 来配置一个新的 Channel 或者其对应的ChannelPipeline 来实现你的网络程序。
 * 当你的程序变的复杂时，可能你会增加更多的处理类到 pipline 上，然后提取这些匿名类到最顶层的类上。
 */
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        //pipeline.addLast(new HttpServerCodec());// http 编解码
        //pipeline.addLast("httpAggregator",new HttpObjectAggregator(512*1024)); // http 消息聚合器                                                                     512*1024为接收的最大contentlength
        //pipeline.addLast(new HttpRequestHandler());// 请求处理器
        pipeline.addLast(new TimeServerHandler());//实现Time协议的Handler
    }
}
