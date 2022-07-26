package com.ty.test.IO;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
public class Demo1 {
    public static void main(String[] args) {
        Properties properties = System.getProperties();

        for (Object key : properties.keySet()) {
            String value = (String) properties.get(key);
            System.out.println(key + "---->" + value);
        }
        String value = properties.getProperty("java.vm.version");
        System.out.println(value);
//        properties.setProperty("myPro","1575825411");
//        System.out.println(properties.getProperty("myPro"));
    }
}

/**
 *
 */
class TestSystem {
    public static void main(String[] args) throws IOException {
        //获取当前系统环境变量
        Map<String, String> map = System.getenv();
        for (Object key : map.keySet()) {
            System.out.println(key + "----->" + map.get(key));
        }

        //获取指定环境变量
        System.out.println(System.getenv("JAVA_HOME"));

        //获取全部变量并保存到文件
        Properties properties = System.getProperties();
        properties.store(new FileOutputStream("properties.txt"), "System properties");

        System.out.println(System.getProperty("os.name"));
    }
}

/**
 *
 */
class CopyTest {
    public static void main(String[] args) {
        int[] src = {11, 22, 33, 44, 55, 66, 77, 88, 99, 10};
        System.out.println(Arrays.toString(src));

        int[] dest = new int[10];
        //浅拷贝，arraycopy  的实现是 Native 实现的
        System.arraycopy(src, 3, dest, 3, 5);
        System.out.println(Arrays.toString(dest));
    }
}

/**
 *
 */
class PropertiesTest {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            count();
        }
    }

    public static void count() throws IOException {
        Properties properties = new Properties();
        File file = new File("count.ini");
        if (!file.exists()) {
            file.createNewFile();
        }
        InputStream is = new FileInputStream(file);
        properties.load(is);
        String times = properties.getProperty("times");
        int count = 0;
        if (times != null) {
            count = Integer.parseInt(times);
            if (count >= 5) {
                System.out.println("你使用的次数已到,请续费!");
            } else {
                System.out.println("正常启动！");
            }
        }
        count++;
        OutputStream os = new FileOutputStream(file);
        properties.setProperty("times", count + "");
        properties.store(os, "count times");
        os.close();
        is.close();

    }
}