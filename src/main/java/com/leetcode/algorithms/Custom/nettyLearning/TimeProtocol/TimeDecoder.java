package com.leetcode.algorithms.Custom.nettyLearning.TimeProtocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

public class TimeDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list)
            throws Exception {
        //基于流的传输比如 TCP/IP, 接收到数据是存在 socket 接收的 buffer 中。
        // 不幸的是，基于流的传输并不是一个数据包队列，而是一个字节队列。意味着，即使你发送了 2 个独立的数据包，
        // 操作系统也不会作为 2 个消息处理而仅仅是作为一连串的字节而言。
        // 因此这是不能保证你远程写入的数据就会准确地读取。举个例子，让我们假设操作系统的 TCP/TP 协议栈已经接收了 3 个数据包：
        //
        //由于基于流传输的协议的这种普通的性质，在你的应用程序里读取数据的时候会有很高的可能性被分成下面的片段
        //
        //因此，一个接收方不管他是客户端还是服务端，都应该把接收到的数据整理成一个或者多个更有意思并且能够让程序的业务逻辑更好理解的数据
        if (byteBuf.readableBytes() < 4) {
            return;
        }

        list.add(new UnixTime(byteBuf.readUnsignedInt()));
    }

}
