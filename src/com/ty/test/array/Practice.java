package com.ty.test.array;

import java.util.*;

public class Practice {
    public static void main(String[] args) {
        list();
        map();
    }


    static String usingUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("-", "");
    }

    static Integer usingInt() {
        Random random = new Random();
        int a = random.nextInt();
        return Math.abs(a);
    }

    static void list() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(usingUUID());
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator:" + iterator.next());
        }

        for (String s :
                list) {
            System.out.println("foreach :" + s);
        }
    }

    static void map() {
        int amount = 0;
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(usingInt(), usingUUID());
        }

        //二次取值
        for (Integer k :
                map.keySet()) {
            String value = map.get(k);
            System.out.println(k + "\t" + "对应" + "\t" + value);
        }

        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            amount ++;
            System.out.println("key= \t" + entry.getKey() + "\t and value= \t" + entry.getValue() +"\t" + amount);
        }

        for (Map.Entry<Integer, String> entry :
                map.entrySet()) {
            System.out.println("fff key= \t" + entry.getKey() + "\t and value= \t" + entry.getValue() +"\t");
        }
    }

}
