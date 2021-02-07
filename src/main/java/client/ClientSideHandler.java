package client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientSideHandler extends ChannelInboundHandlerAdapter {

    private int times;
    private long startTime;
    private NettyClient nettyClient;

    public ClientSideHandler(NettyClient nettyClient) {
        times = 0;
        startTime = System.currentTimeMillis();
        this.nettyClient = nettyClient;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        StringBuffer sb = new StringBuffer("");
        while(in.isReadable()) {
            sb.append((char)in.readByte());
        }
        System.out.println(sb.toString());
        String sendMsg = "";
        if (sb.toString().equals("B: How do you do, Have you eat breakfast?")) {
            sendMsg = "A: Yes, how about you?";
        } else if (sb.toString().equals("B: I am fine, weather is great!")) {
            sendMsg = "A: Right, I am thinking go outside this afternoon.";
        } else {
            sendMsg = "A: How do you do!";
        }
        ByteBuf fmsg = Unpooled.buffer();
        fmsg.writeBytes(sendMsg.getBytes());
        ctx.write(fmsg);
        ctx.flush();
        times ++;
        if (times == 100000) {
            System.out.println("Client side:" + (System.currentTimeMillis() - startTime));
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        String msg = "A: How do you do!";
//        ByteBuf fmsg = Unpooled.buffer();
//        fmsg.writeBytes(msg.getBytes());
//
//        ctx.write(fmsg);
//        ctx.flush();
        this.nettyClient.setChannel(ctx.channel());
    }


}
