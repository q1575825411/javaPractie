package com.ty.test.UDP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DemoTest {
    public static void main(String[] args) throws UnknownHostException {
        getLocalHost();
        getWanHostOne();
    }


    public static void getLocalHost() throws UnknownHostException {
        InetAddress i = InetAddress.getLocalHost();
        System.out.println(i);
        System.out.println("name: " + i.getHostName());
        System.out.println("address: " +
                i.getHostAddress());
    }

    public static void getWanHostOne() throws UnknownHostException {
        InetAddress[] i = InetAddress.getAllByName("www.google.com");
        for (int j = 0;j < i.length;j++){
            System.out.println(i[j]);
        }
    }
}
