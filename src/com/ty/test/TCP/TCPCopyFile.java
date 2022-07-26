package com.ty.test.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPCopyFile {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(65432);
        Socket socket = ss.accept();

        String ip = socket.getInetAddress().getHostAddress();
        System.out.println(ip + "connected....");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //保存
        PrintWriter pw = new PrintWriter(new FileWriter("TCPCopy.txt"),true);

        String line = null;
        while ((line = in.readLine())!=null){
            pw.println(line);
        }

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        out.println("over");
        out.close();
        pw.close();
        socket.close();
        ss.close();
    }

}

class Client3 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",65432);
        BufferedReader br = new BufferedReader(new FileReader("/Users/sm2886/code/java/Internet/src/com/ty/test/TCP/demo.txt"));

        PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

        String line = null;
        while ((line = br.readLine())!=null) {
            pw.println(line);
        }
        //停止等待信号
        socket.shutdownOutput();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String message = reader.readLine();
        System.out.println(message);
        reader.close();
        pw.close();
        br.close();
        socket.close();
    }
}
