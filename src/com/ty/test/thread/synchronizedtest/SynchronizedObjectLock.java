package com.ty.test.thread.synchronizedtest;

/**
 * @author 157
 */
public class SynchronizedObjectLock implements Runnable {
//    static SynchronizedObjectLock instence = new SynchronizedObjectLock();

    @Override
    public void run() {
        synchronized (this) {

            System.out.println("我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }
}
