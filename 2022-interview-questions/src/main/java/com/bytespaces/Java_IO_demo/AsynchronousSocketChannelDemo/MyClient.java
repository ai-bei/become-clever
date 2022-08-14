package com.bytespaces.Java_IO_demo.AsynchronousSocketChannelDemo;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Scanner;

public class MyClient {

    public static void main(String[] args) throws Exception {
        MyClient client = new MyClient();
        String host = "127.0.0.1";
        int port = 8888;
        Scanner scan = new Scanner(System.in);
        String msg = "";
        while(!"exit".equals(msg)) {
            client.init(host, port);
            System.out.print("client enter:");
            msg = scan.nextLine();
            client.writeMsg(msg);
            client.readServerMsg();
        }
    }

    private AsynchronousSocketChannel channel;

    /**
     * 初始化
     * @param host
     * @param port
     * @throws Exception
     */
    public void init(String host,int port) throws Exception {
        channel = AsynchronousSocketChannel.open();
        channel.connect(new InetSocketAddress(host, port));
    }

    /**
     * 读取服务端消息
     * @throws Exception
     */
    public void readServerMsg() throws Exception {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //读取服务端的消息
        //再调用get方法，阻塞一下，将消息完全读出来后再执行后面的语句
        channel.read(buf).get();
        //flip，读取数据
        buf.flip();
        System.out.println("server:" + new String(buf.array(),"UTF-8"));
    }

    public void writeMsg(String msg) throws UnsupportedEncodingException {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(msg.getBytes("UTF-8"));
        //放进通道前，flip
        buf.flip();
        channel.write(buf);
    }

}
