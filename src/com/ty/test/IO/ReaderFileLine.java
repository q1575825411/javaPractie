package com.ty.test.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :
 * @date : 2018/8/30
 * @description:
 */
public class ReaderFileLine {

    public static List<String> getFileContent(String path) {
        List<String> strList = new ArrayList<String>();
        File file = new File(path);
        InputStreamReader read = null;
        BufferedReader reader = null;
        try {
            read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                strList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return strList;
    }

    public static void main(String[] args) {
        String path = "/Users/sm2886/code/java/Internet/text.txt";
        List<String> fileContent =
                ReaderFileLine.getFileContent(path);
        for (String s : fileContent) {
            System.out.println(s);
        }
        System.out.println(fileContent);
    }

}
