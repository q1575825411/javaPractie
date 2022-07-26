package com.ty.test.thread.share;

/**
 * @author sm2886
 */
public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        final MyData myData = new MyData();
        for (int i = 0; i < 2; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    myData.add();
                    myData.add();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    myData.dec();
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(myData.getJ());
    }

}
