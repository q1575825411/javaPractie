package com.ty.test.thread.executor;

import com.ty.test.thread.RunnableDemo;
import com.ty.test.thread.TimeTest;

import java.util.concurrent.*;

/**
 * @author sm2886
 */

public class ExecutorPractice {
    public static void main(String[] args) {
//        fixedThreadPool();
        myThreadPoolExecutor();
    }

    /**
     * 创建规定大小的线程池
     */
    public static void fixedThreadPool() {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Runnable runnable = new RunnableDemo("r1") {
            @Override
            public void run() {
                System.out.println("于" + TimeTest.getStringDate() + "线程" + Thread.currentThread().getName() + "被执行");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        for (int i = 0; i < 100; i++) {
            threadPool.submit(runnable);
            threadPool.execute(runnable);
        }
    }

    public static void myThreadPoolExecutor() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5,
                10, 100, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(100));
        for (int i = 0; i < 50; i++) {
            final int index = i;
            threadPool.execute(() -> {
                System.out.println(index + " 被执行,线程名:" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
