package com.bytespaces.Java_IO_demo.AsynchronousSocketChannelDemo;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class MyServer {

    public static void main(String[] args) {
        new MyServer(8888);
    }

    private AsynchronousServerSocketChannel serverChannel;

    public AsynchronousServerSocketChannel getServerChannel() {
        return this.serverChannel;
    }

    public MyServer(int port) {
        try {
            init(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(int port) throws Exception {
        //开启serverChannel
        this.serverChannel = AsynchronousServerSocketChannel.open();
        //绑定端口，开启服务
        this.serverChannel.bind(new InetSocketAddress(port));
        System.out.println("server start...");
        //启动监听
        this.serverChannel.accept(this, new MyServerHandler());
        System.out.println("server listen port:" + port);
        while(true) {
            //休眠的作用是，保证前台有线程在执行
            //AsynchronousServerSocketChannel的accept方法为守护线程的方式运行，所以需要一个前台线程显示的执行
            Thread.sleep(Long.MAX_VALUE);
        }
    }

}

class MyServerHandler implements CompletionHandler<AsynchronousSocketChannel, MyServer>{

    @Override
    public void completed(AsynchronousSocketChannel channel, MyServer server) {
        //处理下一次的客户端请求
        server.getServerChannel().accept(server, this);
        //业务逻辑，读取客户端消息
        readClientMsg(channel);
    }

    @Override
    public void failed(Throwable exc, MyServer attachment) {
        exc.printStackTrace();
    }

    /**
     * 读取客户端发来的信息
     * @param channel
     */
    public void readClientMsg(final AsynchronousSocketChannel channel) {
        ByteBuffer buf = ByteBuffer.allocate(1024);

        channel.read(buf, buf, new CompletionHandler<Integer, ByteBuffer>(){

            /**
             * 业务逻辑
             * 读取客户端的数据
             */
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                //先flip再使用
                attachment.flip();
                try {
                    //获取客户端发来的信息
                    String clientMsg = new String(attachment.array(),"UTF-8");
                    System.out.println("client:" + clientMsg);
                    writeClientMsg(channel, clientMsg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }

        });
    }

    /**
     * 向客户端写信息
     * @param channel
     * @param clientMsg
     * @throws UnsupportedEncodingException
     */
    public void writeClientMsg(AsynchronousSocketChannel channel, String clientMsg) throws UnsupportedEncodingException {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        String serverMsg = "";
        clientMsg = clientMsg.trim();
        if("0".equals(clientMsg)) {
            serverMsg = "00000000";
        }else if("1".equals(clientMsg)) {
            serverMsg = "11111111";
        }
        else if("exit".equals(clientMsg)) {
            serverMsg = "bye";
        }
        else {
            serverMsg = "-1（不可识别）  --> " + clientMsg;
        }
        buf.put(serverMsg.getBytes("UTF-8"));
        //flip
        buf.flip();
        channel.write(buf);
    }
}