package server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class ChannelHandler extends ChannelInboundHandlerAdapter {

    private int times;
    private long startTime;

    public ChannelHandler() {
        times = 0;
        startTime = System.currentTimeMillis();
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
        if (sb.toString().equals("A: How do you do!")) {
            sendMsg = "B: How do you do, Have you eat breakfast?";
        } else if (sb.toString().equals("A: Yes, how about you?")){
            sendMsg = "B: I am fine, weather is great!";
        } else {
            sendMsg = "B: How do you do, Have you eat breakfast?";
        }
        ByteBuf fmsg = Unpooled.buffer();
        fmsg.writeBytes(sendMsg.getBytes());
        ctx.write(fmsg);
        ctx.flush();
        times ++;
        if (times == 100000) {
            System.out.println("Server side:" + (System.currentTimeMillis() - startTime));
            ctx.channel().disconnect();
        }


//        try {
            while (in.isReadable()) { // (1)
//                System.out.print((char) in.readByte());
//                System.out.flush();
//                ctx.write(msg);
//                ctx.flush();
//                ctx.close();
            }
//        } finally {
//            ReferenceCountUtil.release(msg); // (2)
//        }
    }
}
