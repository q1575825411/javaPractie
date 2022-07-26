package com.ty.test.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UdpSend {
    public static void main(String[] args) throws IOException {
        sendMessageByKeyBoard();
    }

    public static void sendMessage() throws IOException {
        DatagramSocket Socket = new DatagramSocket();

        byte[] buffer = ("运行和调试程序 要运行和" +
                "调试Java代码，请设置断点，然后按键盘上的F5或使" +
                "用运行>开始调试菜单项。 您还可以使用编辑器中的运行|调试" +
                "代码透镜选项。 代码编译后，您可以在运行视图中看到所有变量和线程 ").getBytes();

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 13200);

        Socket.send(packet);
        Socket.close();
    }

    public static void sendMessageByKeyBoard() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket Socket = new DatagramSocket();

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            if ("886".equals(line)) {
                break;
            }
            byte[] buffer = line.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 11111);
            Socket.send(packet);
        }
        Socket.close();
    }
}
