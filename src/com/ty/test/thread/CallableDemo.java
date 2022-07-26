package com.ty.test.thread;

import java.util.concurrent.*;

/**
 * @author sm2886
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        //创建一个Callable，3秒后返回String类型

        Callable myCallable = () -> {
            Thread.sleep(3000);
            System.out.println("calld方法执行了");
            return "call方法返回值";
        };
        System.out.println("提交任务之前 " + TimeTest.getStringDate());
        Future future = executor.submit(myCallable);
        System.out.println("提交任务之后，获取结果之前 " + TimeTest.getStringDate());
        System.out.println("获取返回值: " + future.get());
        System.out.println("获取到结果之后 " + TimeTest.getStringDate());

    }
}
