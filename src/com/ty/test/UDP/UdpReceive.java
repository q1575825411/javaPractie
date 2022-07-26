package com.ty.test.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class UdpReceive {
    public static void main(String[] args) throws Exception {
       receiveMessageByKey();
    }

    public static void receiveMessage() throws IOException {
        DatagramSocket Socket = new DatagramSocket(13200);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        Socket.receive(packet);

        String ip = packet.getAddress().getHostAddress();
        String data = new String(packet.getData(),0,packet.getLength());

        int port = packet.getPort();
        System.out.println(ip + "--" + data + "--" + port);
        Socket.close();
    }


    public static void receiveMessageByKey() throws IOException {
        DatagramSocket socket = new DatagramSocket(11111);
        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            socket.receive(p);

            String ip = p.getAddress().getHostAddress();
            String data = new String(p.getData(),0,p.getLength());
            int port = p.getPort();
            System.out.println(ip);
            System.out.println("\t\t" +
                    data +"\t" +
                    port);
        }
    }

}
