package com.ty.test.thread;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.Callable;

public class CallablePractice implements Callable<ArrayList> {
    private Thread t;
    private String name;
    private ArrayList<String> list;

    public CallablePractice(String name, ArrayList<String> ls) {
        this.name = name;
        this.list = ls;
    }

    @Override
    public ArrayList<String> call() {
        System.out.println(Thread.currentThread().getName() + "进入callable");
        if (list != null) {
            list.add(name + " | " + TimeTest.getStringDate());
        }
        return list;
    }
}
