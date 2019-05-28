package netty.time.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class TimeClientHandlerCumulateBuffer extends ChannelInboundHandlerAdapter {
    private ByteBuf buf;

    public void handlerAdded(ChannelHandlerContext ctx){
        buf = ctx.alloc().buffer(4);
    }

    public void handlerRemoved(ChannelHandlerContext ctx){
        buf.release();
        buf = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf m = (ByteBuf) msg;
//        将读到的数据累积写到另一个buffer
        buf.writeBytes(m);
        m.release();

        if(buf.readableBytes() >= 4){
            long currentTimeMillis = (buf.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
