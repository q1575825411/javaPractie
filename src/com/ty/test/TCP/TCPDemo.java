package com.ty.test.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class TCPDemo {
    public static void main(String[] args) throws IOException {
        //建立一个服务端的socekt服务，绑定监听10001端口
        ServerSocket server = new ServerSocket(10001);
        //获取连接的客户端对象 阻塞式
        Socket client = server.accept();
        String ip = client.getInetAddress().getHostAddress();
        System.out.println(ip +": connected..");
        InputStream is = client.getInputStream();
        byte[] buff = new byte[1024];
        int len = is.read(buff);
        String message = new String(buff,0,len);
        System.out.println(message);


        OutputStream os = client.getOutputStream();
        os.write(("我已经接收到消息" + "\"" +message + "\"").getBytes());
        client.close();
        server.close();
    }
}

class client {
    public static void main(String[] args) throws IOException {
        //创建客户端socket服务，绑定主机和端口
        Socket client = new Socket("127.0.0.1",10001);
        //输出流往服务器输出
        OutputStream os = client.getOutputStream();
        os.write("你好".getBytes());

        InputStream is = client.getInputStream();
        byte[] buff = new byte[1024];
        int len = is.read(buff);
        String message = new String(buff,0,len);
        System.out.println(message);
        client.close();
    }
}
