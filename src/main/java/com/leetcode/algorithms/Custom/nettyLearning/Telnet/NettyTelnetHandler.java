package com.leetcode.algorithms.Custom.nettyLearning.Telnet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.internal.StringUtil;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.Date;

public class NettyTelnetHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /*// Send greeting for a new connection.
        ctx.write("Welcome to " + InetAddress.getLocalHost().getHostName() + "!\r\n");
        ctx.write("It is " + new Date() + " now.\r\n");
        ctx.flush();*/
        for (int i = 1; i <= 5; i++) {
            ctx.writeAndFlush("msg No" + i + " " + StringUtil.LINE_FEED);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String request) throws Exception {

        String response;
        boolean close = false;
        if (request.isEmpty()) {
            response = "Please type something.\r\n";
        } else if ("bye".equals(request.toLowerCase())) {
            response = "Have a good day!\r\n";
            close = true;
        } else {
            response = "Did you say '" + request + "'?\r\n";
        }

        ChannelFuture future = ctx.write(response);
        ctx.flush();
        if (close) {
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }
}
