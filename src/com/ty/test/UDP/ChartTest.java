package com.ty.test.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ChartTest {
    public static void main(String[] args) throws SocketException {
        DatagramSocket receive = new DatagramSocket(11111);
        DatagramSocket send = new DatagramSocket();
        new Thread(new Send(send)).start();
        new Thread(new Receive(receive)).start();
    }
}

class Receive implements Runnable {

    private DatagramSocket socket;
    public Receive(DatagramSocket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        while (true){
            byte[] buffer= new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

            try {
                socket.receive(packet);
                String ip = packet.getAddress().getHostAddress();
                String data = new String(packet.getData(),0, packet.getLength());
                System.out.println(ip);
                System.out.println("\t" + data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Send implements Runnable {

    private DatagramSocket socket;

    public Send (DatagramSocket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        try{
            while ((line = reader.readLine())!=null){
                if ("886".equals(line)) {
                    break;
                }
                byte[] buffer = line.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"),11111);
                socket.send(packet);
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}

