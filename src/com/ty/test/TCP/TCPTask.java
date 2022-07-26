package com.ty.test.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class TCPTask {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(25565);
        Socket client = server.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        String line = null;

        while ((line = in.readLine())!=null) {
            out.write(line);
            //readLine()不读取换行符
            out.newLine();
            //缓冲区刷新
            out.flush();
            System.out.println(line);
        }
        client.close();
        server.close();
    }
}

class ClientTwo {

    public static void main(String[] args) throws IOException {
        Socket client= new Socket("127.0.0.1",25565);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        while ((line = reader.readLine())!= null) {
            if ("over".equals(line)) {
                break;
            }
            out.write(line);
            out.newLine();
            out.flush();
            String serverLine = in.readLine();
            System.out.println(serverLine.toUpperCase());
        }
        reader.close();
        client.close();
    }
}
