package com.ty.test.IO;

import java.io.*;
import java.net.URLDecoder;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.TimeZone;

public class FilePractice {
    public static void main(String[] args) throws IOException {

        ZoneId id = TimeZone.getDefault().toZoneId();
        System.out.println(id);


        //创建文件对象
        File file = new File("a.txt");

        //构建FileOutputStream 自动创建文件
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        //OutputStreamWriter 指定编码格式
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "UTF-8");

        writer.append("笑死").flush();
        writer.append("\t\n");
        writer.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");
        StringBuilder stringBuilder = new StringBuilder();
        while (reader.ready()) {
            stringBuilder.append((char) reader.read());
        }

        Scanner s = new Scanner(new BufferedReader(new FileReader(file)));
        s.useDelimiter("/n");
        while (s.hasNext()) {
             System.out.println(s.next());
//             String keyWord = URLDecoder.decode(s.next(), "utf8");
//             System.out.println(keyWord);
        }

        System.out.println("鸡汤来啰");
//        System.out.println("我" + stringBuilder.toString());
        fileInputStream.close();
        reader.close();
    }
}
