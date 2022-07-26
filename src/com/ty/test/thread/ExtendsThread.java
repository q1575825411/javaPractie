package com.ty.test.thread;

import java.util.ArrayList;

/**
 * @author sm2886
 */
public class ExtendsThread extends Thread {

    private Thread t;
    private String name;
    private ArrayList<String> ls;

    public ExtendsThread(String name) {
        this.name = name;
    }

    public ExtendsThread(ArrayList<String> list) {
        ls = list;
    }

    public ExtendsThread(String name, ArrayList<String> list) {
        this.ls = list;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Running! " + name);
        if (ls != null) {
            ls.clear();
            ls.add(name + " | " + TimeTest.getStringDate());
        }
        try {
            for (int i = 0; i < 3; i++) {
//                System.out.println("Thread  " + name + " | " + i + " | " + TimeTest.getStringDate());
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Thread " + name + "interrupted");
        }
        System.out.println("Thread " + name + "exited");
        System.out.println(name + " 的" + "ls 内容是 " + ls);
    }

    public void start() {
        System.out.println("Start " + name);
        if (t == null) {
            t = new Thread(this, name);
            t.start();
        }
    }


}
