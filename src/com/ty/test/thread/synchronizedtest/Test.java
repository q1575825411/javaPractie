package com.ty.test.thread.synchronizedtest;

import com.ty.test.thread.share.MyData;


/**
 * @author 157
 */
public class Test {


    public static void main(String[] args) {
        test2();
    }

    /*
    synchronized 以非静态方法锁出现的时候，锁住的对象是调用方法的对象。
    当调用方法对象唯一时，会出现阻塞，当调用方法对象不唯一，无事发生.
    诸如test1()当中我们声明了一个data对象去调用时，会出现阻塞。

    synchronized 修饰静态方法时，锁住的是类对象，默认是当前所在类class，
    无论哪个线程访问，锁只有一把。
    */
    public static void test1() {
        MyData data = new MyData();
        MyData data1 = new MyData();
        new Thread(() -> {
            data.add();
        }, "A").start();
        new Thread(() -> {
            data.dec();
        }, "B").start();
    }


    public static void test2(){
        SynchronizedObjectLock sy = new SynchronizedObjectLock();
        Thread r1 = new Thread(sy);
        Thread r2 = new Thread(sy);
        r1.start();
        r2.start();
    }
}
