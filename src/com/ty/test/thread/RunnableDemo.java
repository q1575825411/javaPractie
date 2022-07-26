package com.ty.test.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 实现Runnable接口
 *
 * @author sm2886
 */
public class RunnableDemo implements Runnable {
    private Thread t;
    private String name;

    private ArrayList<String> ls;
    List<String> list = Collections.synchronizedList(new ArrayList<>());

    Object object = new Object();

    public RunnableDemo(String name) {
        this.name = name;
    }

    public RunnableDemo(ArrayList<String> list) {
        ls = list;
    }

    public RunnableDemo(String name, ArrayList<String> list) {
        this.list = list;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Running! " + name);
        if (ls != null) {
            synchronized (object) {
                ls.add(name + " | " + TimeTest.getStringDate());
            }
        }
        System.out.println("Thread " + name + "exited");
//        System.out.println(name + " 的" + "ls 内容是 " + ls);
    }

    public void start() {
        System.out.println("Start " + name);
        if (t == null) {
            t = new Thread(this, name);
            t.start();
        }
    }
}
