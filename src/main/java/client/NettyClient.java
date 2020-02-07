package client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    private Channel channel;

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public void connect() throws Exception {

        EventLoopGroup worker = new NioEventLoopGroup();
        final ClientSideHandler clientSideHandler = new ClientSideHandler(this);

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(clientSideHandler);
                }
            });
            ChannelFuture f = bootstrap.connect("localhost", 8080).sync();
//            String msg = "A: How do you do!";
//            this.channel.writeAndFlush(msg.getBytes());
            f.channel().closeFuture().sync();



        } finally {
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        final NettyClient client = new NettyClient();
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    client.connect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        String msg = "A: How do you do!";
        client.sendMessage(msg);
    }

    public boolean sendMessage(String msg) {
        while (this.getChannel() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ByteBuf fmsg = Unpooled.buffer();
        fmsg.writeBytes(msg.getBytes());
        this.getChannel().write(fmsg);
        this.getChannel().flush();
        return true;
    }


}
