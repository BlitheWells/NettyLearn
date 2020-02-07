package server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
	
	private int port;
	
	public NettyServer(int port) {
		this.port = port;
	}
	
	public void run() throws Exception {
		EventLoopGroup boos = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();

		try {
			ServerBootstrap sb = new ServerBootstrap();
			sb.group(boos, worker)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new ChannelHandler());
						}
					})
					.option(ChannelOption.SO_BACKLOG, 128)
					.childOption(ChannelOption.SO_KEEPALIVE, true);

			ChannelFuture f = sb.bind(port).sync();
			f.channel().closeFuture().sync();
		} finally {
			boos.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		new NettyServer(8080).run();
	}

}
