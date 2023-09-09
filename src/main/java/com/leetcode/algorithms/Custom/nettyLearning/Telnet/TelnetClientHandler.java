package com.leetcode.algorithms.Custom.nettyLearning.Telnet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Handles a client-side channel.
 */
@Sharable
public class TelnetClientHandler extends SimpleChannelInboundHandler<String> {

    protected void messageReceived(ChannelHandlerContext ctx, String msg) {
        System.err.println(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    // count 变量，用于计数
    private int count;

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg)
			throws Exception {
		// TODO Auto-generated method stub
        System.out.println("服务器读取线程 " + Thread.currentThread().getName());

        System.out.println("服务器接收到数据：" + msg);
        // 打印接收的次数
        System.out.println("接收到的数据量是：" + (++this.count));
	}
}
