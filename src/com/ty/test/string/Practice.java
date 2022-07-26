package com.ty.test.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) throws IOException {
        StringBuffer stringBuffer = new StringBuffer(10);
        StringBuilder stringBuilder = new StringBuilder(10);
        //Scanner
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
        //BufferReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bs = null;
        do {
            bs = String.valueOf((char) br.read());
            System.out.println(bs);
        } while (!Objects.equals(bs, "q"));

        stringBuffer.append(bs);
        stringBuilder.append(bs);
        stringBuffer.reverse();
//        stringBuffer.replace(0, 1, "她");
        stringBuilder.reverse();

        System.out.println(stringBuilder + "\t" + stringBuffer);
    }
}
