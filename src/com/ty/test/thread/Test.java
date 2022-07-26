package com.ty.test.thread;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author sm2886
 */

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final int size = 500;

        ArrayList<String> ls = new ArrayList<>();

        Vector<String> vs = new Vector<>();
        vs.add("apple");
        ls.add("apple");
        List<String> list = Collections.synchronizedList(ls);
        System.out.println("线程执行前ls: " + ls);
        System.out.println("线程执行前vs: " + vs);

        Thread threads[] = new Thread[size];
        FutureTask<ArrayList>[] futureTasks = new FutureTask[size];
        RunnableDemo runnableDemo[] = new RunnableDemo[size];
        for (int i = 0; i < size; i++) {
            String name = "c" + i;
//            futureTasks[i] = new FutureTask<>(new CallablePractice(name,ls));
//            threads[i] = new Thread(futureTasks[i]);
//            threads[i].start();
//            runnableDemo[i] = new RunnableDemo(name, ls);
//            runnableDemo[i].start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add(Thread.currentThread().getName() + TimeTest.getStringDate());
                    vs.add(Thread.currentThread().getName() + TimeTest.getStringDate());
                }
            }).start();


        }


//        for (int i = 0; i < size; i++) {
//            System.out.println("result" + i + "= " +futureTasks[i].get());
//            System.out.println();
//        }

        System.out.println("线程执行后ls " + list);
        System.out.println("线程执行后vs " + vs.size());


    }
}


